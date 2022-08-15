package com.ysjleader.tobyspringkotlin.controller

import com.ysjleader.tobyspringkotlin.chapter05.dto.request.MemberDTO
import com.ysjleader.tobyspringkotlin.chapter05.service.MemberService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/member")
@RestController
class MemberController(
    private val memberService: MemberService
) {

    private val log = LoggerFactory.getLogger(MemberController::class.java)

    @PostMapping("/sign-up")
    fun signUp(@RequestBody memberDTO: MemberDTO): MemberDTO {
        return memberService.singUp(memberDTO)
    }

    @PostMapping("/login")
    fun login(@RequestBody memberDTO: MemberDTO): MemberDTO {
        return memberService.login(
            id = memberDTO.memberId,
            password =  memberDTO.password
        )
    }

    @PostMapping("/update-member-levels")
    fun updateMemberLevels(): String {
        return memberService.updateMemberLevels()
    }
}