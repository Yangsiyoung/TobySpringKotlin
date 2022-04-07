package com.ysjleader.tobyspringkotlin.chapter02.v1.login

import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.dto.UserDTO
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate

class RestTemplateLoginService: LoginService {

    private val log = LoggerFactory.getLogger(this::class.java)

    override fun login(userDTO: UserDTO): ResponseEntity<Boolean> {
        log.info("##### RestTemplateLoginService.login()")
        val restTemplate = RestTemplate()
        val requestURL = "http://localhost:9090/api/v1/login"
        return restTemplate.postForEntity(requestURL, userDTO, Boolean::class.java)
    }

}