package com.ysjleader.tobyspringkotlin.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class UserDTO(
    @JsonProperty("user_id")
    val id: String = "",
    @JsonProperty("user_name")
    val name: String = "",
    @JsonProperty("user_password")
    val password: String? = null
) {
}