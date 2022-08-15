package com.ysjleader.tobyspringkotlin.chapter05.domain

import com.ysjleader.tobyspringkotlin.chapter05.domain.level.MemberLevel
import org.slf4j.LoggerFactory

data class Member(
    val memberId: String = "",
    val password: String = "",
    val nickName: String = "",
) {

    private val log = LoggerFactory.getLogger(Member::class.java)

    var level: MemberLevel = MemberLevel.BASIC
        private set

    var loginCount: Int = 0
        private set

    var recommendedCount: Int = 0
        private set

    // @Transient 등을 통해 영속화 대상이 아니게 해야함
    val LOGIN_COUNT_FOR_SILVER: Int = 50

    // @Transient 등을 통해 영속화 대상이 아니게 해야함
    val RECOMMEND_COUNT_FOR_GOLD: Int = 50

    fun checkAndUpdateLevel() {
        log.info("checkAndUpdateLevel() Start : previous Level => ${level}")
        if(isOverLoginCount()) level = level.nextLevel!!
        if(isOverRecommendCount()) level = level.nextLevel!!
        log.info("checkAndUpdateLevel() End : Current Level => ${level}")
    }

    fun plusLoginCount() {
        log.info("plusLoginCount() Start : previous Login Count => ${loginCount}")
        if(Member() != this) loginCount += 1
        log.info("plusLoginCount() End : Current Login Count => ${loginCount}")
    }

    fun plusRecommendedCount() {
        log.info("plusRecommendedCount() Start : previous Recommended Count => ${recommendedCount}")
        if(Member() != this) recommendedCount += 1
        log.info("plusRecommendedCount() End : Current Recommended Count => ${recommendedCount}")
    }

    private fun isOverLoginCount(): Boolean {
        return (MemberLevel.BASIC == level)
                && (LOGIN_COUNT_FOR_SILVER <= loginCount)
    }

    private fun isOverRecommendCount(): Boolean {
        return (MemberLevel.SILVER == level)
                && (RECOMMEND_COUNT_FOR_GOLD <= recommendedCount)
    }
}