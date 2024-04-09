package com.spring.backend.mail;

import java.io.IOException;
import java.io.StringWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
@Transactional(readOnly = true)
public class SendMail {
	
    @Value("${spring.mail.username}")
    private String mailFrom;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private Configuration freemarkerConfig;
	
	// 2. MimeMessageHelper를 이용한 방법(HTML 레이아웃,이미지, 파일첨부 가능)
	public void sendEmailDetail(MailDto mailDto){
		try {
			
			MimeMessage msg = mailSender.createMimeMessage(); // MimeMessageHelper는 MimeMessage를 보다 쉽게 구성하고 이메일을 보낼 수 있도록 도움 
			MimeMessageHelper helper = new MimeMessageHelper(msg, true); // => MimeMessageHelper의 생성자는 MimeMessage를 인수로 받아함
			
			// 이메일 템플릿 가지고 오기
			StringWriter out = new StringWriter();
			Template template = freemarkerConfig.getTemplate(mailDto.getTemplate()+".html");
			template.process(mailDto.getParams(), out);
			String emailContent = out.toString();
			
			// 이메일 설정값
	        helper.setFrom(mailDto.getSender() != null ? mailDto.getSender() : mailFrom); // 보내는 사람 이메일 주소 => 구글 stmt기준 안먹힘
//	        helper.setTo(mailDto.getReceiver()); // 받는 사람 이메일 주소
	        helper.setTo(mailDto.getReceivers().toArray(new String[]{}));
	        helper.setSubject(mailDto.getTitle()); // 이메일 제목
	        helper.setText(emailContent, true); // 이메일 본문(String text, boolean html)
	        mailSender.send(msg);
	        
		} catch (MessagingException | IOException | TemplateException e) {
			System.out.printf("sendEmail error - {}", e.getMessage());
		}
	}
	

	
	
	
	
}
