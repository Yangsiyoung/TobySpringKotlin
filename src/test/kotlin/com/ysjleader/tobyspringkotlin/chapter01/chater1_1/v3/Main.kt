package com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v3

import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.dto.UserDTO

fun main() {
    val userService: AbstractUserService = UserServiceWithRestTemplate()
    userService.callLoginAPI(UserDTO())
    userService.getUserInfo(UserDTO())
    userService.updateUserName(UserDTO())
}