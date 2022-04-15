package com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v7

import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.dto.UserDTO
import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v7.factory.ProfileUserServiceFactory
import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v7.user.UserService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class MainTest {

    @Test
    fun getUserInfoTest() {
        val applicationContext = AnnotationConfigApplicationContext()
        applicationContext.environment.setActiveProfiles("local")
        applicationContext.environment.defaultProfiles
        applicationContext.register(ProfileUserServiceFactory::class.java)
        applicationContext.refresh()
        val userService = applicationContext.getBean("userService", UserService::class.java)
        val result = userService.getUserInfo(UserDTO(id = "userId01", password = "userPassword"))
        Assertions.assertNotNull(result.name)
        println(result.name)

    }

    @Test
    fun updateUserNameTest() {
        val applicationContext = AnnotationConfigApplicationContext()
        applicationContext.environment.setActiveProfiles("production")
        applicationContext.register(ProfileUserServiceFactory::class.java)
        applicationContext.refresh()
        val userService = applicationContext.getBean("userService", UserService::class.java)
        val result = userService.updateUserName(UserDTO(id = "userId01", name = "ChangeName", password = "userPassword"))
        Assertions.assertEquals("ChangeName", result.name)
    }

}