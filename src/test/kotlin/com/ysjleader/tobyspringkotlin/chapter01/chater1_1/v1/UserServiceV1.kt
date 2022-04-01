package com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v1

import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.dto.UserDTO
import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.repository.fake.FakeUserRepository
import org.springframework.web.client.RestTemplate

class UserServiceV1(
    private val userRepository: FakeUserRepository = FakeUserRepository()
) {


    fun getUserInfo(userDTO: UserDTO): UserDTO {
        requireNotNull(userDTO.id)
        requireNotNull(userDTO.password)
        val restTemplate = RestTemplate()
        val requestURL = "http://localhost:9090/api/v1/login"
        val responseEntity = restTemplate.postForEntity(requestURL, userDTO, Boolean::class.java)
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
        val restTemplate = RestTemplate()
        val requestURL = "http://localhost:9090/api/v1/login"
        val responseEntity = restTemplate.postForEntity(requestURL, userDTO, Boolean::class.java)
        val responseStatus = responseEntity.statusCode
        if(responseStatus.is2xxSuccessful && responseEntity.body!!) {
            return UserDTO.fromEntity(userRepository.updateUserName(id = userDTO.id, name = userDTO.name!!))
        }else {
            throw IllegalArgumentException("Invalid Input")
        }
    }
}