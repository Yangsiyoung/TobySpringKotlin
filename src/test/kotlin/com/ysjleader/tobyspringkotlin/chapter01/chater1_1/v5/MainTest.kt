package com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v5

import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.dto.UserDTO
import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v5.login.RestTemplateLoginService
import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v5.login.WebClientLoginService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MainTest {
    @Test
    fun getUserInfoRestTemplateTest() {
        val userService = UserService(loginService = RestTemplateLoginService())
        val result = userService.getUserInfo(UserDTO(id = "userId01", password = "userPassword"))
        Assertions.assertNotNull(result.name)
        println(result.name)

    }

    @Test
    fun updateUserNameRestTemplateTest() {
        val userService = UserService(loginService = RestTemplateLoginService())
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