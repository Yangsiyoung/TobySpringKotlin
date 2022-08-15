package com.ysjleader.tobyspringkotlin.chapter05.domain.level

enum class MemberLevel(
    val desc: String,
    val nextLevel: MemberLevel?
) {
    GOLD(desc = "SILVER 레벨에서 30번 이상 추천", null)
    , SILVER(desc = "BASIC 레벨에서 50번 이상 로그인", GOLD)
    , BASIC(desc = "최초 가입 레벨", nextLevel = SILVER)
}