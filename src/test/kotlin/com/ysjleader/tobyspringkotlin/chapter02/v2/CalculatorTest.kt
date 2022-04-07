package com.ysjleader.tobyspringkotlin.chapter02.v2

import com.ysjleader.tobyspringkotlin.chapter02.v2.calculator.CalculatorV1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun sumTest() {
        val calculator = CalculatorV1()
        val result = calculator.plus(1, 2, 3, 4, 5)
        val expect = 15
        assertEquals(expect, result)
    }
}