package com.ysjleader.tobyspringkotlin.chapter01.chater1_1

import com.fasterxml.jackson.databind.ObjectMapper
import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.dto.UserDTO
import org.springframework.http.HttpStatus
import org.springframework.web.client.RestTemplate

class UserService {


    fun getUserInfo(userDTO: UserDTO): UserDTO {
        val objectMapper = ObjectMapper()
        val restTemplate = RestTemplate()
        val requestURL = "http://localhost:9090/api/v1/login"
        val responseEntity = restTemplate.postForEntity(requestURL, userDTO, UserDTO::class.java)
        val responseStatus = responseEntity.statusCode
        return if(responseStatus.is2xxSuccessful) responseEntity.body!!
               else userDTO.copy(name = "Invalid User Name")

    }
}