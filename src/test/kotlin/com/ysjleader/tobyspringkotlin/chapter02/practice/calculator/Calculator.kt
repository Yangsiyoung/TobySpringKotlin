package com.ysjleader.tobyspringkotlin.chapter02.practice.calculator

interface Calculator {

    fun plus(vararg numbers: Int): Int

    fun minus(leftNumber: Int, rightNumber: Int): Int

    fun divide(leftNumber: Int, rightNumber: Int): Int

}