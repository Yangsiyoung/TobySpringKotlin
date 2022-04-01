package com.ysjleader.tobyspringkotlin.chapter01.chater1_1.repository

import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.entity.User

interface UserRepository {
    fun createUser(user: User): User
    fun findUserById(id: String): User
    fun updateUserName(id: String, name: String): User
}