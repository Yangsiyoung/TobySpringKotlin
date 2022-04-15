package com.ysjleader.tobyspringkotlin.chapter03.solid.dip

import com.ysjleader.tobyspringkotlin.chapter03.solid.dip.repository.UserRepository
import com.ysjleader.tobyspringkotlin.chapter03.solid.dip.service.UserService
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class UserControllerTest {

    @DisplayName("컨트롤러 테스트하는데 서비스 모킹 어려울까?")
    @Test
    fun mockTest() {
        val userController = UserController(userService = UserService(userRepository = MyRepository()))
    }

    private class MyRepository: UserRepository {

    }

}