package com.spring.backend.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/notice")
@Tag(name = "Notice Controller", description = "공지사항 정보 관련 API")
public class NoticeController {
	
	@Autowired
	NoticeService noticeService;
	
	// 여러 명 같은 내용 이메일 발송
	@PostMapping("/add")
	@Operation(summary = "공지사항 등록", description= "공지사항을 등록합니다.")
	public String findIdMail(@RequestBody NoticeEntity notice) {
		noticeService.noticeAdd(notice);
		return null;
	}

}
