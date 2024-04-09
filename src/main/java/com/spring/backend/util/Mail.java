package com.spring.backend.util;

public enum Mail {
	WELCOME("member_join"),
	NOTICE("notice"),
	QNA("qna_reply"),
	TEMP_PWD("member_pwd");
	

    private final String value;

    Mail(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
	
}
