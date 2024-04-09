package com.spring.backend.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.backend.mail.MailDto;
import com.spring.backend.mail.SendMail;
import com.spring.backend.member.MemberRepository;
import com.spring.backend.util.Mail;


@Service
public class NoticeService {
	
	@Autowired
	private SendMail sendMail;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private NoticeRepository noticeRepository;


	public ResponseEntity<Map<String, Object>> noticeAdd(NoticeEntity notice) {
		
		if(notice != null) {
			// 데이터 저장
			noticeRepository.save(notice);

			// 이메일 발송
			List<String> receivers = memberRepository.findMail();
			if(receivers != null) {
				MailDto mailDto = new MailDto();
				mailDto.setTemplate(Mail.NOTICE.getValue()); // 템플릿 이름
				mailDto.setTitle("[공지사항]: " + notice.getNoticeTitle()); // 이메일 제목
				mailDto.setReceivers(receivers); // 수신자
				mailDto.setSender("admin"); // 발신자

				Map<String, Object> params = new HashMap<>();
				params.put("title", notice.getNoticeTitle());
				params.put("contents", notice.getNoticeContents());
				mailDto.setParams(params);
				
				sendMail.sendEmailDetail(mailDto);
				
			}
		}
		return null;
	}
	
	
}
