package com.ysjleader.tobyspringkotlin.chapter02.v2.calculator

class CalculatorV1: Calculator {
    override fun plus(vararg numbers: Int): Int {
        return numbers.sum()
    }
}