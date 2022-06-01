package com.ysjleader.tobyspringkotlin.chapter03.composition.v2

/**
 * Composition
 */
class UserAPICall(
    private val apiCall: APICall
) {

    /**
     * userNo 로 회원 정보 조회
     * @param url  String
     * @param userNo 회원번호
     * @return 회원정보
     */
    fun callUserInfoAPI(url: String, userNo: String): String {
        val result = apiCall.callAPI(url = url, param = userNo)
        if(result == null) {
            throw UserNotFoundException()
        }
        // 조회한 userNo 원격지에 로깅
        return result
    }

    private class UserNotFoundException: Exception()
}