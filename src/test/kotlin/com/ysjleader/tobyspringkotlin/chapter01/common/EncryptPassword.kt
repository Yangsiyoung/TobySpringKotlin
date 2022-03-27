package com.ysjleader.tobyspringkotlin.chapter01.common

class EncryptPassword {
    companion object {
        fun encrypt(password: String): String {
            return "encrypted password ${password}"
        }
    }
}