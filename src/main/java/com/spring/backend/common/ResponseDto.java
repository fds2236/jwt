package com.spring.backend.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor 
public class ResponseDto {
	private String statusCd;
    private String msg;
    
    // 객체를 JSON으로 직렬화
//    @JsonInclude(JsonInclude.Include.NON_NULL) // null이 아닌 값만 직렬화
    private Object data;

}
