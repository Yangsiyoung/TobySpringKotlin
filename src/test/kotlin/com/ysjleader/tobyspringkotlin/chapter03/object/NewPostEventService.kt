package com.ysjleader.tobyspringkotlin.chapter03.`object`

import com.ysjleader.tobyspringkotlin.chapter03.`object`.service.LoginService
import com.ysjleader.tobyspringkotlin.chapter03.`object`.service.UserService

class NewPostEventService(
    private val userService: UserService,
    private val loginService: LoginService,
    private val postService: PostService
) {

    fun publishNewPostEvent() {
        // Login 했는지 확인
        loginService.checkLogin()
        // 로그인한 User 정보를 가져옴
        userService.getUserInfo()
        // User 의 게시글 조회
        postService.findUserPosts()
        // User 의 게시글에 최신글이 추가되면 구독자에 알람
        publishEvent()
    }

    private fun publishEvent() {
        TODO("Not yet implemented")
    }

}