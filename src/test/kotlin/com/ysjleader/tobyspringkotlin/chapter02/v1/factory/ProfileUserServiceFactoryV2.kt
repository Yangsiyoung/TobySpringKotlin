package com.ysjleader.tobyspringkotlin.chapter02.v1.factory

import com.ysjleader.tobyspringkotlin.chapter02.v1.login.RestTemplateLoginService
import com.ysjleader.tobyspringkotlin.chapter02.v1.login.WebClientLoginService
import com.ysjleader.tobyspringkotlin.chapter02.v1.user.UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
class ProfileUserServiceFactoryV2 {

    @Profile(value = ["local"])
    @Bean("userServiceV2")
    fun userService(): UserService {
        return UserService(loginService = RestTemplateLoginService())

    }

    @Profile(value = ["!local"])
    @Bean("userServiceV2")
    fun prodUserService(): UserService {
        return UserService(loginService = WebClientLoginService())
    }

}