package com.ysjleader.tobyspringkotlin.chapter02.v3

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.jvm.isAccessible

class ReflectionTest {

    @DisplayName("public 함수 호출")
    @Test
    fun callPublicFun() {
        val clazz = TestClass::class

        clazz.declaredFunctions.forEach {
            if(!it.isAccessible) {
                it.isAccessible = true
            }
            it.call(clazz.createInstance(), "Test Param")
        }

    }
}

class TestClass {

    fun publicFunction01(param01: String) {
        println("Call publicFunction01 with param01 : ${param01}")
    }

    private fun publicFunction02(param01: String) {
        println("Call publicFunction02 with param01 : ${param01}")
    }
}