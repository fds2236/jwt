package com.spring.backend.mail;
import java.util.List;
import java.util.Map;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.backend.member.MemberEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/etc")
@Slf4j
@Tag(name = "Etc Controller", description = "연습용 API")
public class EtcController {
	
	// RequestParam, RequestBody, PathVariable, HttpServletRequest
	
	// @RequestParam: List과 Map 가능, 객체 불가능
	@GetMapping("/get1")
	@Operation(summary = "get 요청 연습용1")
	// http://localhost:8090/etc/get1?member=string1&member=string2&member=string3
	// http://localhost:8090/etc/get1?member=string1,string2,string3 둘 다 가능
	public ResponseEntity<String> get1(@Parameter(description = "회원 목록", example = "test1,test2,test3") @RequestParam("member") List<String> member){
		log.info("member: " + member);
		return null;
	}
	
	@GetMapping("/get2")
	@Operation(summary = "get 요청 연습용2")
	// http://localhost:8090/etc/get2?memberId=string&memberPwd=string&memberMail=string
	public ResponseEntity<String> get2(@Parameter(description = "회원 엔티티") @RequestParam Map<String, Object> member){
		log.info("member: " + member);
		return null;
	}
	
	// @ParameterObject: 객체 가능, List와 Map 권장되지 않음, openAPI 스웨거에서 만든 어노테이션
	// 일반적으로 객체의 구조를 명확히 정의하고 사용해야 함
	@GetMapping("/get3")
	@Operation(summary = "get 요청 연습용3")
	// http://localhost:8090/etc/get3?memberId=fds2236&memberName=silverbell&memberPwd=asdf1234&memberAddr=seoul&memberMail=test%40naver.com
	public ResponseEntity<String> get3(@Parameter(description = "회원 엔티티") @ParameterObject MemberEntity memberEntity){
		log.info("memberEntity: " + memberEntity);
		return null;
	}
	
	@PostMapping("/post1")
	@Operation(summary = "post 요청 연습용1")
	public ResponseEntity<String> post1(@Parameter(description = "회원 엔티티") @RequestBody List<String> member){
		log.info("member: " + member);
		// member: [silver, gold]
		return null;
	}
	
	@PostMapping("/post2")
	@Operation(summary = "post 요청 연습용2")
	public ResponseEntity<String> post2(@Parameter(description = "회원 엔티티") @RequestBody Map<String, Object> member){
		log.info("member: " + member);
		// member: {memberId=fds, memberPwd=asdf}
		return null;
	}
	
	@PostMapping("/post3")
	@Operation(summary = "post 요청 연습용3")
	public ResponseEntity<String> post3(@Parameter(description = "회원 엔티티") @RequestBody MemberEntity member){
		log.info("memberEntity: " + member);
		// memberEntity: MemberEntity(memberSnum=null, memberId=fds, memberName=null, memberPwd=asdf, memberAddr=null, memberMail=null, memberRegDate=null)
		return null;
	}
	
	
	

	
}