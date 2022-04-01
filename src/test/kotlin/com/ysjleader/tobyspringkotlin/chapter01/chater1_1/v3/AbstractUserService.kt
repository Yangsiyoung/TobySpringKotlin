package com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v3

import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.dto.UserDTO
import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.repository.fake.FakeUserRepository
import org.springframework.http.ResponseEntity

abstract class AbstractUserService(
    private val userRepository: FakeUserRepository = FakeUserRepository()
) {

    fun getUserInfo(userDTO: UserDTO): UserDTO {
        requireNotNull(userDTO.id)
        requireNotNull(userDTO.password)
        val responseEntity = callLoginAPI(userDTO)
        val responseStatus = responseEntity.statusCode
        if(responseStatus.is2xxSuccessful && responseEntity.body!!) {
            return UserDTO.fromEntity(userRepository.findUserById(userDTO.id))
        }else {
            throw IllegalArgumentException("Invalid Input")
        }
    }

    fun updateUserName(userDTO: UserDTO): UserDTO {
        requireNotNull(userDTO.id)
        requireNotNull(userDTO.password)
        requireNotNull(userDTO.name)
        val responseEntity = callLoginAPI(userDTO)
        val responseStatus = responseEntity.statusCode
        if(responseStatus.is2xxSuccessful && responseEntity.body!!) {
            return UserDTO.fromEntity(userRepository.updateUserName(id = userDTO.id, name = userDTO.name!!))
        }else {
            throw IllegalArgumentException("Invalid Input")
        }
    }

    abstract fun callLoginAPI(userDTO: UserDTO): ResponseEntity<Boolean>
}