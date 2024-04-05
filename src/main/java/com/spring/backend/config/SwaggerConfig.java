package com.spring.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI openAPI() {
		return new OpenAPI().components(new Components())
				.info(new Info()
						.title("jwt_security")
						.description("backend cofig 및 환경셋팅 연습")
						.contact(new Contact()
								.name("eunjong")
								.email("fds2236@naver.com")));
	}
}
