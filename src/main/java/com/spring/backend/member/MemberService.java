package com.spring.backend.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.backend.mail.MailDto;
import com.spring.backend.mail.SendMail;
import com.spring.backend.util.Mail;

@Service
public class MemberService {
	
	@Autowired
	private SendMail sendMail;

	@Autowired
	private MemberRepository memberRepostiory;
	
	public ResponseEntity<Map<String, Object>> join(MemberEntity member){

			if(member != null) {
				// 이메일 중복 확인
//				if(memberRepostiory.existsByMemberMail(member.getMemberMail())) {
//					return null;
//				}
				
				// 데이터 저장
				memberRepostiory.save(member);
				
				// 이메일 발송
				MailDto mailDto = new MailDto();
				mailDto.setTemplate(Mail.WELCOME.getValue());
				mailDto.setTitle("회원가입하신 것을 축하드립니다.");
//				mailDto.setReceiver(member.getMemberMail());
				mailDto.setReceivers(List.of(member.getMemberMail()));
				mailDto.setSender("admin");
				
				Map<String, Object> params = new HashMap<>();
				params.put("name", member.getMemberName());
				mailDto.setParams(params);
				
				sendMail.sendEmailDetail(mailDto);
			}
		return null;
	}
	

	
	

	
	
	
	

}
