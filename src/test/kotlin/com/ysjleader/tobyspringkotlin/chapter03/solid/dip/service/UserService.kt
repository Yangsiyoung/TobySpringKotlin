package com.ysjleader.tobyspringkotlin.chapter03.solid.dip.service

import com.ysjleader.tobyspringkotlin.chapter03.solid.dip.repository.UserRepository

class UserService(
    private val userRepository: UserRepository
): UserServiceInterface {
}