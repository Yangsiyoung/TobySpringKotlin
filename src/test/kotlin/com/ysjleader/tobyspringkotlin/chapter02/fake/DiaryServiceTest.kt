package com.ysjleader.tobyspringkotlin.chapter02.fake

import com.ysjleader.tobyspringkotlin.chapter02.fake.domain.User
import com.ysjleader.tobyspringkotlin.chapter02.fake.repository.impl.FakeUserRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DiaryServiceTest {

    @Test
    fun postTest() {
        val fakeUserRepository = FakeUserRepository()
        val user = User(userId = "userId01", name = "userName01")
        fakeUserRepository.save(user)
        val diaryService = DiaryService(userRepository = fakeUserRepository)
        val expect = "${user.name}:contents"
        val result = diaryService.postDiary(user.userId, "contents")
        assertEquals(expect, result)
    }
}