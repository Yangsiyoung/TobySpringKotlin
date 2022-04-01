package com.ysjleader.tobyspringkotlin.chapter01.chater1_1.repository.fake

import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.entity.User
import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.repository.UserRepository

class FakeUserRepository: UserRepository {

    private val userMap: MutableMap<String, User> = hashMapOf("userId01" to User(id = "userId01", name = "userName01", password = "userPassword01"))

    override fun createUser(user: User): User {
        userMap[user.id] = user
        return userMap[user.id] ?: throw Exception("뭔 에러일까,,,")
    }

    override fun findUserById(id: String): User {
        return userMap[id] ?: throw Exception("User Not Found Exception")
    }

    override fun updateUserName(id: String, name: String): User {
        userMap[id]?.name = name
        return userMap[id] ?: throw Exception("User Not Found Exception")
    }
}