package com.ysjleader.tobyspringkotlin.chapter02.v1.login

import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.dto.UserDTO
import org.springframework.http.ResponseEntity

interface LoginService {
    fun login(userDTO: UserDTO): ResponseEntity<Boolean>
}