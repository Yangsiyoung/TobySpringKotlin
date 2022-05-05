package com.ysjleader.tobyspringkotlin.chapter03.delegation.repository.delegation

import com.ysjleader.tobyspringkotlin.chapter03.domain.User
import com.ysjleader.tobyspringkotlin.chapter03.repository.UserRepository
import com.ysjleader.tobyspringkotlin.chapter03.repository.fake.UserRepositoryImpl
import org.slf4j.LoggerFactory

class DelegationUserRepository(
    private val userRepository: UserRepository = UserRepositoryImpl()
): UserRepository {
    private val log = LoggerFactory.getLogger(DelegationUserRepository::class.java)

    override fun save(user: User): User {
        log.info(" save user : ${user}")
        return userRepository.save(user)
    }

    override fun update(user: User): User {
        log.info(" update user : ${user}")
        return userRepository.update(user)
    }

}