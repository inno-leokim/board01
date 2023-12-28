package com.brand13.board01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        
        // 현재 로그인 페이지는 살아있는 상태에서 다른 페이지 접속 가능! 만약 formLogin 안에 permitAll이 없다면 모든페이지 접속 전 로그인 페이지 뜰 것!
        return http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
		.formLogin(form -> form
			// .loginPage()
			.permitAll() 
		).build();

    }
}
