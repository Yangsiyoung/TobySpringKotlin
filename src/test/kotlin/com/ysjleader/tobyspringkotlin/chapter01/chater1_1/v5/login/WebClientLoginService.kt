package com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v5.login

import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.dto.UserDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.body
import reactor.core.publisher.Mono

class WebClientLoginService: LoginService {
    override fun login(userDTO: UserDTO): ResponseEntity<Boolean> {
        val requestURL = "http://localhost:9090/api/v1/login"
        val webclient = WebClient.builder()
            .baseUrl(requestURL)
            .build()
        val resultMono = webclient
            .post()
            .body<UserDTO>(Mono.just(userDTO))
            .retrieve()
            .bodyToMono(Boolean::class.java)
        return ResponseEntity.ok(resultMono.block()!!)
    }
}