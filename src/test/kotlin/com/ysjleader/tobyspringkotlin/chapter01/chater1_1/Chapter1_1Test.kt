package com.ysjleader.tobyspringkotlin.chapter01.chater1_1

import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.dto.UserDTO
import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v3.UserServiceWithRestTemplate
import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v4.UserService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class Chapter1_1Test {

    @Test
    fun userServiceTest() {
        val userService = UserServiceWithRestTemplate()
        val result = userService.getUserInfo(UserDTO(id = "userId01", password = "userPassword"))
        assertNotNull(result.name)
        println(result.name)

    }

    @Test
    fun updateTest() {
        val userService = UserServiceWithRestTemplate()
        val result = userService.updateUserName(UserDTO(id = "userId01", name = "ChangeName", password = "userPassword"))
        assertEquals("ChangeName", result.name)
    }

//    @Test
//    fun userServiceWebClientTest() {
//        val userService = UserServiceWithWebClient()
//        val result = userService.getUserInfo(UserDTO(id = "userId01", password = "userPassword"))
//        assertNotNull(result.name)
//        println(result.name)
//
//    }
//
//    @Test
//    fun updateWebClientTest() {
//        val userService = UserServiceWithWebClient()
//        val result = userService.updateUserName(UserDTO(id = "userId01", name = "ChangeName", password = "userPassword"))
//        assertEquals("ChangeName", result.name)
//    }

    @Test
    fun userServiceWebClientTest() {
        val userService = UserService()
        val result = userService.getUserInfo(UserDTO(id = "userId01", password = "userPassword"))
        assertNotNull(result.name)
        println(result.name)

    }

    @Test
    fun updateWebClientTest() {
        val userService = UserService()
        val result = userService.updateUserName(UserDTO(id = "userId01", name = "ChangeName", password = "userPassword"))
        assertEquals("ChangeName", result.name)
    }
}