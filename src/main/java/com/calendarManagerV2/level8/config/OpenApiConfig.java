package com.calendarManagerV2.level8.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 생성될 API 문서의 기초적인 정보 설정
//@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("일정 관리 앱 V2 API")
                .version("1.0")
                .description("API 문서 설명"));
    }
}