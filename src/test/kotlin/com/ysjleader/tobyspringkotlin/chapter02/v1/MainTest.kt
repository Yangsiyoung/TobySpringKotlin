package com.ysjleader.tobyspringkotlin.chapter02.v1

import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.dto.UserDTO
import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v7.user.UserService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles


@ActiveProfiles(value = ["unittest"])
@SpringBootTest
class MainTest {

    @Value("\${login.url}")
    lateinit var url: String

    @Autowired
    lateinit var userService: UserService

    @BeforeEach
    fun init() {
        println(url)
    }

    @Test
    fun getUserInfoTest() {
        val result = userService.getUserInfo(UserDTO(id = "userId01", password = "userPassword"))
        Assertions.assertNotNull(result.name)
        println(result.name)

    }

    @Test
    fun updateUserNameTest() {
        val result = userService.updateUserName(UserDTO(id = "userId01", name = "ChangeName", password = "userPassword"))
        Assertions.assertEquals("ChangeName", result.name)
    }

}