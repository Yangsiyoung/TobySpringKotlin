package com.ysjleader.tobyspringkotlin

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles(value = ["unittest"])
@SpringBootTest
class TobySpringKotlinApplicationTests {

    @Value("\${test.property.param}")
    lateinit var param: String

    @Test
    fun contextLoads() {
        println(param)
        assertEquals("Radi Zzang!!!", param)
    }

}
