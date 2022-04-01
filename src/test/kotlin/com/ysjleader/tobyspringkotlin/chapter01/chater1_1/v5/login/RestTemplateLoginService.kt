package com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v5.login

import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.dto.UserDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate

class RestTemplateLoginService: LoginService {
    override fun login(userDTO: UserDTO): ResponseEntity<Boolean> {
        val restTemplate = RestTemplate()
        val requestURL = "http://localhost:9090/api/v1/login"
        return restTemplate.postForEntity(requestURL, userDTO, Boolean::class.java)
    }

}