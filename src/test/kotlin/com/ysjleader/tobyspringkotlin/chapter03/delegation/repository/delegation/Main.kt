package com.ysjleader.tobyspringkotlin.chapter03.delegation.repository.delegation

import com.ysjleader.tobyspringkotlin.chapter03.delegation.repository.fake.UserRepositoryImpl
import com.ysjleader.tobyspringkotlin.chapter03.domain.User
import com.ysjleader.tobyspringkotlin.chapter03.dto.UserDTO

fun main() {
    val userRepository = DelegationUserRepository()
    userRepository.save(
        User(userId = "userId01", userName = "userName01", userAddress = "userAddress01")
    )
    userRepository.update(
        User(userId = "userId01", userName = "userName01", userAddress = "userAddress01")
    )
}