package com.brand13.board01.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@Configuration
public class JpaConfig {
    // 누가 만들었는지 자동을 인식하기 위해 설정한다.

    @Bean
    public AuditorAware<String> auditorAware(){
        return () -> Optional.of("brand13"); // TODO: 스프링 시큐리티로 인증 기능을 붙이게 될 때, 수정하자.
    }
}
