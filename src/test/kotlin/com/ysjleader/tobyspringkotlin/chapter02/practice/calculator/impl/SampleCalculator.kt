package com.ysjleader.tobyspringkotlin.chapter02.practice.calculator.impl

import com.ysjleader.tobyspringkotlin.chapter02.practice.calculator.Calculator
import org.slf4j.LoggerFactory

class SampleCalculator: Calculator {

    val log = LoggerFactory.getLogger(SampleCalculator::class.java)

    override fun plus(vararg numbers: Int): Int {
        log.info("plus Start!!!")
        return numbers.sum()
    }

    override fun minus(leftNumber: Int, rightNumber: Int): Int {
        log.info("minus Start!!!")
        return leftNumber - rightNumber
    }

    override fun divide(leftNumber: Int, rightNumber: Int): Int {
        if(rightNumber == 0) throw IllegalArgumentException()
        return leftNumber / rightNumber
    }

}