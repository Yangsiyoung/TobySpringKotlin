package com.ysjleader.tobyspringkotlin.chapter02.v1.factory

import com.ysjleader.tobyspringkotlin.chapter02.v1.login.WebClientLoginService
import com.ysjleader.tobyspringkotlin.chapter02.v1.user.UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UserServiceFactoryV2 {

    @Bean("cuteService2")
    fun testUserService(): UserService {
//        return UserService(loginService = RestTemplateLoginService())
        return UserService(loginService = WebClientLoginService())
    }


}