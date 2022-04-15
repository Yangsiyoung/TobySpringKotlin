package com.ysjleader.tobyspringkotlin.chapter03.delegation

import org.slf4j.LoggerFactory


class CustomMutableList<T>(
    private val list: MutableList<T> = mutableListOf()
): MutableList<T> by list {

    private val log = LoggerFactory.getLogger(CustomMutableList::class.java)

    override fun add(element: T): Boolean {
        log.info("before add element size is : ${list.size}")
        val result = list.add(element)
        log.info("after add element size is : ${list.size}")
        return result
    }
}