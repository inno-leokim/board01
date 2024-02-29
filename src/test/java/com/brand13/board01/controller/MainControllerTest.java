package com.brand13.board01.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import com.brand13.board01.config.SecurityConfig;

@Import(SecurityConfig.class) //SecurityConfig 설정이 전체에 적용될 수 있도록 허용
@WebMvcTest(MainController.class)
public class MainControllerTest {

    private final MockMvc mvc;

    public MainControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @Test
    void givenNothing_whenRequestingRootPage_thenRedirectsToArticlesPage() throws Exception{
        // Given

        // When & Then
        mvc.perform(get("/"))
            .andExpect(status().is3xxRedirection());
    }
}
