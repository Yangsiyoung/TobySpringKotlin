package com.ysjleader.tobyspringkotlin.chapter03.solid.dip

import com.ysjleader.tobyspringkotlin.chapter03.solid.dip.service.UserService

class UserController(
    private val userService: UserService
) {
}