package com.ysjleader.tobyspringkotlin.chapter02.fake

import com.ysjleader.tobyspringkotlin.chapter02.fake.repository.UserRepository

class DiaryService(
    private val userRepository: UserRepository
) {
    fun postDiary(userId: String, contents: String): String {
        val findUser = userRepository.findById(userId)
        // 글쓰기 로직에 findUser 의 이름 넣어서 저장
        // 글쓰기를 저장
        return "${findUser.name}:${contents}"
    }
}