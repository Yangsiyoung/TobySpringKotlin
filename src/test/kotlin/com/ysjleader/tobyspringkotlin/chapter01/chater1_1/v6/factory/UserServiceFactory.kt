package com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v6.factory

import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v6.login.RestTemplateLoginService
import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v6.user.UserService

class UserServiceFactory {

    fun userService(): UserService {
        return UserService(loginService = RestTemplateLoginService())
    }

}