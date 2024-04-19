package com.spring.backend.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/member")
@Tag(name = "Member Controller", description = "멤버 정보 관련 API")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/join")
	@Operation(summary = "회원 가입", description = "회원을 등록합니다.")
	public ResponseEntity<String> memberAdd(@RequestBody MemberEntity member){
		memberService.join(member);
		return null;
	}
	
	
	@PostMapping("/login")
	@Operation(summary="로그인", description = "로그인합니다.")
	public ResponseEntity<String> login(@RequestBody MemberEntity member){
		memberService.login(member);
		return null;
	}

	
}

 