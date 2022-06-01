package com.ysjleader.tobyspringkotlin.chapter03.template_method

import com.ysjleader.tobyspringkotlin.chapter03.template_method.v2.RestTemplateAPICall
import com.ysjleader.tobyspringkotlin.chapter03.template_method.v2.UserService
import com.ysjleader.tobyspringkotlin.chapter03.template_method.v2.WebClientAPICall

fun main() {
    val userService = UserService(apiCall = RestTemplateAPICall())
    val userService02 = UserService(apiCall = WebClientAPICall())
    userService.getUserInfo("", "")
}