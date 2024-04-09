package com.spring.backend.mail;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Datapublic class MailDto {
	public String title; // 이메일 제목
	public String sender; // 발신자
	public String receiver; // 수신자
	public List<String> receivers; // 수신자 목록
	public String template; // 이메일 템플릿 이름
	public Map<String, Object> params;
}
