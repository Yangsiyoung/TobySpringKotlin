package com.ysjleader.tobyspringkotlin.chapter03.template_method.v2

class RestTemplateAPICall: AbstractAPICall() {

    override fun callAPI(url: String, param: String): String? {
        println("RestTemplate 호출 : ${url} : ${param}")
        return "UserInfo"
    }

}