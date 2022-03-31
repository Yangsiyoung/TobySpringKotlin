package com.ysjleader.tobyspringkotlin.controller

import com.ysjleader.tobyspringkotlin.dto.UserDTO
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/login")
@RestController
class LoginController {

    @PostMapping
    fun login(@RequestBody userDTO: UserDTO): UserDTO {
        requireNotNull(userDTO.id)
        requireNotNull(userDTO.password)
        return userDTO.copy(name = "Valid User Name")
    }
}