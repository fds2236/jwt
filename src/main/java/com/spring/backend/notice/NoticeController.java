package com.spring.backend.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	// 공지사항 등록 => 여러 명 같은 내용 이메일 발송
	@PostMapping("/add")
	@Operation(summary = "공지사항 등록", description= "공지사항을 등록합니다.")
	public String noticeAdd(@RequestBody NoticeEntity notice) {
		noticeService.noticeAdd(notice);
		return null;
	}
	
	@DeleteMapping("/delete/{uuid}")
//	@PreAuthorize("hasAnyRole('ROLE_ADMIN')") // ROLE_ADMIN 역할을 가진 사용자만 호출 가능 => 메소드 단위 권한 체크
	@Operation(summary = "공지사항 삭제", description= "공지사항을 삭제합니다.")
	public String noticeDelete(@PathVariable String uuid) {
		
			return null;
	}
	
	@PutMapping("update/{uuid}")
	@Operation(summary = "공지사항 수정", description= "공지사항을 수정합니다.")
	public String noticeUpdate() {
		return null;
	}
	
	
	
	
	
	
	
	
}
