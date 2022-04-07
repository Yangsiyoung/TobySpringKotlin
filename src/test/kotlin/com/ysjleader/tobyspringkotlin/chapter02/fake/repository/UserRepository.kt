package com.ysjleader.tobyspringkotlin.chapter02.fake.repository

import com.ysjleader.tobyspringkotlin.chapter02.fake.domain.User

interface UserRepository {
    fun save(user: User): User
    fun findById(userId: String): User
}