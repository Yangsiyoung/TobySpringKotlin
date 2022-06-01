package com.ysjleader.tobyspringkotlin.chapter03.composition.v2

interface APICall {

    fun callAPI(url: String, param: String): String?

}