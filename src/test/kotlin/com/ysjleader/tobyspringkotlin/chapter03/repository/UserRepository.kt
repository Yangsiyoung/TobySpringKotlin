package com.ysjleader.tobyspringkotlin.chapter03.repository

import com.ysjleader.tobyspringkotlin.chapter03.domain.User

interface UserRepository {

    fun save(user: User): User
    fun update(user: User): User
}