package com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v3

import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.dto.UserDTO
import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.repository.fake.FakeUserRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.body
import reactor.core.publisher.Mono

class UserServiceWithWebClient(
    userRepository: FakeUserRepository = FakeUserRepository()
): AbstractUserService(userRepository = userRepository) {

    override fun callLoginAPI(userDTO: UserDTO): ResponseEntity<Boolean> {
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