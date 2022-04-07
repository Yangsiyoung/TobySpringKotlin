package com.ysjleader.tobyspringkotlin.chapter02.private_fun

import kotlin.reflect.KFunction
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.jvm.isAccessible

// 아직 보지마세요
fun main() {
    val clazz = TestClass::class

    clazz.declaredFunctions
        .filter { isPrivateFunction(it) }
        .forEach {
        val instance = clazz.createInstance()
        it.isAccessible = true
        it.call(instance)
    }

}

fun isPrivateFunction(method: KFunction<*>): Boolean {
    println("method : ${method.name}, accessible : ${method.isAccessible}")
    return !method.isAccessible
}


open class TestClass {

    open fun publicFunction() {
        println("Call publicFunction")
    }

    private fun privateFunction() {
        println("Call privateFunction")
    }
}