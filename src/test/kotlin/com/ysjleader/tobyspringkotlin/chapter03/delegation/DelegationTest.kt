package com.ysjleader.tobyspringkotlin.chapter03.delegation

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class DelegationTest {

    @DisplayName("Delegation 이 잘 동작하나")
    @Test
    fun delegationTest() {
        val customMutableList = CustomMutableList<String>()
        customMutableList.add("Test String 01")
        customMutableList.add("Test String 02")
        customMutableList.add("Test String 03")
        val stringList = listOf("list String 01", "list String 02", "list String 03")
        customMutableList.addAll(stringList)
    }
}