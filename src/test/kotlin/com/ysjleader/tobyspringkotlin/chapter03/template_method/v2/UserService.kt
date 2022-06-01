package com.ysjleader.tobyspringkotlin.chapter03.template_method.v2

class UserService(
    private val apiCall: AbstractAPICall
) {

    fun getUserInfo(url: String, userNo: String ) {
        apiCall.callUserInfoAPI(
            url = url,
            userNo = userNo
        )
    }

}