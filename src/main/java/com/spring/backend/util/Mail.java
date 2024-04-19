package com.spring.backend.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Mail {
	WELCOME("member_join"),
	NOTICE("notice"),
	QNA("qna_reply"),
	TEMP_PWD("member_pwd");

    private final String value;
	
}
