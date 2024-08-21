//package com.example.studyKotlin.config
//
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.data.domain.AuditorAware
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing
//import java.util.*
//
//@Configuration
//@EnableJpaAuditing
//class JpaConfig {
//
//    @Bean
//    fun auditorProvider(): AuditorAware<String> {
//        return AuditorAware { Optional.of("system") } // 현재 사용자 정보를 반환하도록 변경 가능
//    }
//}
