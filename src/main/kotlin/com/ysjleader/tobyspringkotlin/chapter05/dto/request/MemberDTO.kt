package com.ysjleader.tobyspringkotlin.chapter05.dto.request

data class MemberDTO(
    val memberId: String = "",
    val password: String = "",
    val nickName: String = ""
) {
}