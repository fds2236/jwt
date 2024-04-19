package com.spring.backend.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    ADMIN("ROLE_ADMIN"),
    MANAGER("ROLE_MANAGER"),
    OPERATOR("ROLE_OPERATOR"),
    USER("ROLE_USER");

    private String value;

}
