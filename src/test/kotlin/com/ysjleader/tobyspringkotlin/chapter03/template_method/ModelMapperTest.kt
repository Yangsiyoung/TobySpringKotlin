package com.ysjleader.tobyspringkotlin.chapter03.template_method

import com.ysjleader.tobyspringkotlin.chapter03.config.ModelMapperFactory
import com.ysjleader.tobyspringkotlin.chapter03.domain.User
import com.ysjleader.tobyspringkotlin.chapter03.dto.UserDTO
import com.ysjleader.tobyspringkotlin.chapter03.repository.fake.UserRepositoryImpl
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ModelMapperTest {

    @DisplayName("모델 매퍼가 잘 동작하나아")
    @Test
    fun modelMapperTest() {
        val modelMapper = ModelMapperFactory.getInstance()
        val user = User(userId = "userId01", userName = "userName01", userAddress = "userAddress01")
        val expect = UserDTO(userId = "userId01", userName = "userName01", userAddress = "userAddress01")
        val actual = modelMapper.map(user, UserDTO::class.java)
        assertEquals(expect, actual)
    }

    @DisplayName("ModelMapperUserService 테스트 - createUser")
    @Test
    fun createUserTest() {
        val modelMapperUserService = ModelMapperUserService(userRepository = UserRepositoryImpl())
        val expect = UserDTO(userId = "userId01", userName = "userName01", userAddress = "userAddress01")
        val actual = modelMapperUserService.createUser(expect)
        assertEquals(expect, actual)
    }

    @DisplayName("ModelMapperUserService 테스트 - updateUser")
    @Test
    fun updateUserTest() {
        val modelMapperUserService = ModelMapperUserService(userRepository = UserRepositoryImpl())
        val userDTO = UserDTO(userId = "userId01", userName = "userName01", userAddress = "userAddress01")
        modelMapperUserService.createUser(userDTO)
        val expect = UserDTO(userId = "userId01", userName = "changedName", userAddress = "changedAddress")
        val actual = modelMapperUserService.changeUserInfo(expect)
        assertEquals(expect, actual)
    }

    @DisplayName("UserService 테스트 - createUser")
    @Test
    fun createUserInUserServiceTest() {
        val userService = UserService(userRepository = UserRepositoryImpl())
        val expect = UserDTO(userId = "userId01", userName = "userName01", userAddress = "userAddress01")
        val actual = userService.createUser(expect)
        assertEquals(expect, actual)
    }

    @DisplayName("UserService 테스트 - updateUser")
    @Test
    fun updateUserInUserServiceTest() {
        val userService = UserService(userRepository = UserRepositoryImpl())
        val userDTO = UserDTO(userId = "userId01", userName = "userName01", userAddress = "userAddress01")
        userService.createUser(userDTO)
        val expect = UserDTO(userId = "userId01", userName = "changedName", userAddress = "changedAddress")
        val actual = userService.changeUserInfo(expect)
        assertEquals(expect, actual)
    }

}