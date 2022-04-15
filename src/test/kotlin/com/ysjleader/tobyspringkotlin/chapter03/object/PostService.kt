package com.ysjleader.tobyspringkotlin.chapter03.`object`

import com.ysjleader.tobyspringkotlin.chapter03.`object`.service.LoginService
import com.ysjleader.tobyspringkotlin.chapter03.`object`.service.UserService

class PostService(
    private val userService: UserService,
    private val loginService: LoginService
) {

    fun createPost() {
        // Login 했는지 확인
        loginService.checkLogin()
        // 로그인한 User 정보를 가져옴
        userService.getUserInfo()
        // 글쓰기
        post()
    }

    fun findUserPosts() {

    }

    private fun post() {
        TODO("Not yet implemented")
    }
}