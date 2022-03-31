package com.ysjleader.tobyspringkotlin.chapter01.chater1_1.dto

data class UserDTO(
    var id: String = "",
    var name: String? = null,
    var password: String? = null
) {
}