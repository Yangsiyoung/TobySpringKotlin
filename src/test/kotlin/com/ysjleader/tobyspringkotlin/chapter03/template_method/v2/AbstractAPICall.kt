package com.ysjleader.tobyspringkotlin.chapter03.template_method.v2

/**
 * Template Method Pattern : Inheritance
 *
 */
abstract class AbstractAPICall {

    /**
     * userNo 로 회원 정보 조회
     * @param url  String
     * @param userNo 회원번호
     * @return 회원정보
     */
    fun callUserInfoAPI(url: String, userNo: String): String {
        val result = callAPI(url = url, param = userNo)
        if(result == null) {
            throw UserNotFoundException()
        }
        // 조회한 userNo 원격지에 로깅
        return result
    }

    /**
     * Http Call :
     *              1) RestTemplate
     *              2) WebClient
     *              3) FeignClient
     */
    protected abstract fun callAPI(url: String, param: String): String?

    private class UserNotFoundException: Exception()
}