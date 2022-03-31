package com.ysjleader.tobyspringkotlin.chapter01.chater1_1

import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.dto.UserDTO
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class Chapter1_1Test {

    @Test
    fun userServiceTest() {
        val userService = UserService()
        val result = userService.getUserInfo(UserDTO(id = "userId", password = "userPassword"))
        assertNotNull(result.name)

    }
}