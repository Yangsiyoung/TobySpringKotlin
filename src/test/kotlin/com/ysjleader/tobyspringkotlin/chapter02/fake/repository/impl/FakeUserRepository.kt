package com.ysjleader.tobyspringkotlin.chapter02.fake.repository.impl

import com.ysjleader.tobyspringkotlin.chapter02.fake.domain.User
import com.ysjleader.tobyspringkotlin.chapter02.fake.repository.UserRepository

class FakeUserRepository: UserRepository {

    private val userMap: HashMap<String, User> = hashMapOf()

    override fun save(user: User): User {
        userMap[user.userId] = user
        return userMap[user.userId] ?: throw IllegalArgumentException("뭥미")
    }

    override fun findById(userId: String): User {
        return userMap[userId] ?: throw IllegalArgumentException("없음여")
    }
}