package com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v6

import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.dto.UserDTO
import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v6.factory.UserServiceFactory
import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v6.login.WebClientLoginService
import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v6.user.UserService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MainTest {
    @Test
    fun getUserInfoRestTemplateTest() {
        val userService = UserServiceFactory().userService()
        val result = userService.getUserInfo(UserDTO(id = "userId01", password = "userPassword"))
        Assertions.assertNotNull(result.name)
        println(result.name)

    }

    @Test
    fun updateUserNameRestTemplateTest() {
        val userService = UserServiceFactory().userService()
        val result = userService.updateUserName(UserDTO(id = "userId01", name = "ChangeName", password = "userPassword"))
        Assertions.assertEquals("ChangeName", result.name)
    }

    @Test
    fun getUserInfoWebClientTest() {
        val userService = UserService(loginService = WebClientLoginService())
        val result = userService.getUserInfo(UserDTO(id = "userId01", password = "userPassword"))
        Assertions.assertNotNull(result.name)
        println(result.name)

    }

    @Test
    fun updateUserNameWebClientTest() {
        val userService = UserService(loginService = WebClientLoginService())
        val result = userService.updateUserName(UserDTO(id = "userId01", name = "ChangeName", password = "userPassword"))
        Assertions.assertEquals("ChangeName", result.name)
    }
}