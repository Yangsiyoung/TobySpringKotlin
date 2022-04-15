package com.ysjleader.tobyspringkotlin.chapter02.practice

import com.ysjleader.tobyspringkotlin.chapter02.practice.calculator.Calculator
import com.ysjleader.tobyspringkotlin.chapter02.practice.calculator.impl.SampleCalculator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

class CalculatorTest {

    lateinit var calculator: Calculator

    @DisplayName("계산기 덧셈 테스트")
    @Test
    fun plusTest() {
        calculator = SampleCalculator()
        val expect = 15
        val actual = calculator.plus(1, 2, 3, 4, 5)
        assertEquals(expect, actual)
    }

    @DisplayName("계산기 뺄셈 테스트")
    @Test
    fun minusTest() {
        calculator = SampleCalculator()
        val expect = -1
        val actual = calculator.minus(leftNumber = 1, rightNumber = 2)
        assertEquals(expect, actual)
    }

    @DisplayName("나눗셈 테스트 - 정상")
    @Test
    fun divideTest() {
        calculator = SampleCalculator()
        var expect = 1
        var actual = calculator.divide(2, 2)
        assertAll(
            {assertEquals(expect, actual)},
            {
                expect = 2
                actual = calculator.divide(2, 1)
                assertEquals(expect, actual)
            },
            {
                expect = 3
                actual = calculator.divide(3, 1)
                assertEquals(expect, actual)
            },
            {
                expect = 4
                actual = calculator.divide(4, 1)
                assertEquals(expect, actual)
            },

        )
    }

    @DisplayName("나눗셈 테스트 - rightNumber 가 0 이면 에러")
    @Test
    fun divideExceptionTest() {
        calculator = SampleCalculator()
        assertThrows<IllegalArgumentException> { calculator.divide(100, 0) }
    }
}