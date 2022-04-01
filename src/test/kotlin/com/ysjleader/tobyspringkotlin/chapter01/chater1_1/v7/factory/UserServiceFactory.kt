package com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v7.factory

import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v7.login.WebClientLoginService
import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v7.user.UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UserServiceFactory {

    @Bean("cuteService")
    fun testUserService(): UserService {
//        return UserService(loginService = RestTemplateLoginService())
        return UserService(loginService = WebClientLoginService())
    }


}