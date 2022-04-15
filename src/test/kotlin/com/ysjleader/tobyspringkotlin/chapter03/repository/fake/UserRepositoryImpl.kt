package com.ysjleader.tobyspringkotlin.chapter03.repository.fake

import com.ysjleader.tobyspringkotlin.chapter03.domain.User
import com.ysjleader.tobyspringkotlin.chapter03.repository.UserRepository

class UserRepositoryImpl: UserRepository {

    private val userMap = mutableMapOf<String, User>()

    override fun save(user: User): User {
        userMap[user.userId] = user
        return userMap[user.userId] ?: throw IllegalArgumentException("Save Exception!!!")
    }

    override fun update(user: User): User {
        val findUser = userMap[user.userId] ?: throw IllegalArgumentException("Not Exist User!!!")
        userMap[findUser.userId] = user
        return userMap[user.userId] ?: throw IllegalArgumentException("Update Exception!!!")
    }
}