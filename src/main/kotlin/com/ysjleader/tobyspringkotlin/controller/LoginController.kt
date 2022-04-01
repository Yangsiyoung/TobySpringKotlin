package com.ysjleader.tobyspringkotlin.controller

import com.ysjleader.tobyspringkotlin.dto.UserDTO
import com.ysjleader.tobyspringkotlin.service.LoginService
import com.ysjleader.tobyspringkotlin.service.LoginServiceImplV1
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/login")
@RestController
class LoginController(
    private val loginService: LoginService
) {

    @PostMapping
    fun login(@RequestBody userDTO: UserDTO): Boolean {
        requireNotNull(userDTO.id)
        requireNotNull(userDTO.password)
        return true
    }
}