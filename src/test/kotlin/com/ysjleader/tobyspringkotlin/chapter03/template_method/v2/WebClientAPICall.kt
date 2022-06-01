package com.ysjleader.tobyspringkotlin.chapter03.template_method.v2

class WebClientAPICall: AbstractAPICall() {
    override fun callAPI(url: String, param: String): String? {
        println("WebClient 호출 : ${url} : ${param}")
        return "UserInfo"
    }
}