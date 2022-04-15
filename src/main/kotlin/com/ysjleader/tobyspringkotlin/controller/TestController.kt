package com.ysjleader.tobyspringkotlin.controller

import com.ysjleader.tobyspringkotlin.dto.UserDTO
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/test")
@RestController
class TestController {

    @PostMapping
    fun getData(@RequestBody userDTO: UserDTO): UserDTO {
        return userDTO
    }
}