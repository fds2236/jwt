package com.spring.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

// 스프링 시큐리티를 사용하려면 보안 구성을 정의해야함
// 보안 규칙을 설정하고 사용자 인증 및 권한 부여를 구성하는 부분
@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록됨
@RequiredArgsConstructor
public class SecurityConfig {


//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		return http
				.csrf(AbstractHttpConfigurer::disable) // Cross-Site Request Forgery 보호 비활성화
				
//				.formLogin(Customizer.withDefaults()) // 폼 로그인 설정

				// authorizeHttpRequests => HTTP 요청에 대한 인증 및 권한 부여 규칙을 설정
				// authenticated 인증된 사용자 접근 허용
				// permitAll 모든 사용자 허용
				.authorizeHttpRequests(authorizeRequest -> authorizeRequest
						// controller 관련
						.requestMatchers("/member/**", "notice/**", "etc/**").permitAll()
//						.requestMatchers("notice/delete/**").hasRole("ROLE_ADMIN")
						// swagger 관련
						.requestMatchers("/swagger", "/swagger-ui.html", "/swagger-ui/**", "/api-docs", "/api-docs/**", "/v3/api-docs/**").permitAll()
						.anyRequest().permitAll()
				)
				


				.build();
	}

}
