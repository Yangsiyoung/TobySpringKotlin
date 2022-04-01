package com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v3

import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.dto.UserDTO
import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.repository.fake.FakeUserRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate

class UserServiceWithRestTemplate(
    userRepository: FakeUserRepository = FakeUserRepository()
): AbstractUserService(userRepository = userRepository) {

    override fun callLoginAPI(userDTO: UserDTO): ResponseEntity<Boolean> {
        val restTemplate = RestTemplate()
        val requestURL = "http://localhost:9090/api/v1/login"
        return restTemplate.postForEntity(requestURL, userDTO, Boolean::class.java)
    }

}