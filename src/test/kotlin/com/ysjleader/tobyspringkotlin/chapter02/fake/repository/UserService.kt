package com.ysjleader.tobyspringkotlin.chapter02.fake.repository

import com.ysjleader.tobyspringkotlin.chapter02.fake.domain.User

class UserService(
    private val userRepository: UserRepository
) {
    fun createUser(user: User): User {
        return userRepository.save(user = user)
    }
}