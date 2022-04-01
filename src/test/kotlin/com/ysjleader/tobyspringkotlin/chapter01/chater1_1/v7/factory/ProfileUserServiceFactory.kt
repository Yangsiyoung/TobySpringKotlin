package com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v7.factory

import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v7.login.RestTemplateLoginService
import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v7.login.WebClientLoginService
import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v7.user.UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
class ProfileUserServiceFactory {

    @Profile(value = ["local"])
    @Bean("userService")
    fun userService(): UserService {
        return UserService(loginService = RestTemplateLoginService())

    }

    @Profile(value = ["production"])
    @Bean("userService")
    fun prodUserService(): UserService {
        return UserService(loginService = WebClientLoginService())
    }

}