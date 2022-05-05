package com.ysjleader.tobyspringkotlin.chapter03.composition


import com.ysjleader.tobyspringkotlin.chapter03.composition.converter.impl.ConstructorDtoConverter
import com.ysjleader.tobyspringkotlin.chapter03.composition.converter.impl.ModelMapperDtoConverter
import com.ysjleader.tobyspringkotlin.chapter03.dto.UserDTO
import com.ysjleader.tobyspringkotlin.chapter03.repository.fake.UserRepositoryImpl
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ModelMapperTest {

    @DisplayName("ModelMapperDtoConverter 테스트 - createUser")
    @Test
    fun createUserTest() {
        val expect = UserDTO(userId = "userId01", userName = "userName01", userAddress = "userAddress01")
        val userService = UserService(userRepository = UserRepositoryImpl(), dtoConverter = ModelMapperDtoConverter())
        val actual = userService.createUser(expect)
        assertEquals(expect, actual)
    }

    @DisplayName("ConstructorDtoConverter 테스트 - createUser")
    @Test
    fun createUserUsingConstructTest() {
        val expect = UserDTO(userId = "userId01", userName = "userName01", userAddress = "userAddress01")
        val userService = UserService(userRepository = UserRepositoryImpl(), dtoConverter = ConstructorDtoConverter())
        val actual = userService.createUser(expect)
        assertEquals(expect, actual)
    }

}