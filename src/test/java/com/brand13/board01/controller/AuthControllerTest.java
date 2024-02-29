package com.brand13.board01.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.brand13.board01.config.SecurityConfig;

@DisplayName("View 컨트롤러 - 인증")
@Import(SecurityConfig.class) //SecurityConfig 설정이 전체에 적용될 수 있도록 허용
@WebMvcTest
public class AuthControllerTest {
    private final MockMvc mvc;

    public AuthControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[view][GET] 로그인 페이지 - 정상 호출")
    @Test
    public void givenNothing_whenTryingToLogin_thenReturnsLoginView() throws Exception{
        // Given

        // When & Then
        mvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
                // .andExpect(view().name("articles/index")) //view 이름은 따로 없다. 스프링시큐리티에서 자동으로 만들기 때문.
                

    }
}
