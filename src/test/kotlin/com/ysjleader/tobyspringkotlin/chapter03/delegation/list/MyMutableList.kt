package com.ysjleader.tobyspringkotlin.chapter03.delegation.list

import org.slf4j.LoggerFactory

class MyMutableList<T>(
    private val list: MutableList<T> = mutableListOf()
): MutableList<T> by list{

    private val log = LoggerFactory.getLogger(MyMutableList::class.java)

    override fun add(element: T): Boolean {
        log.info("Add : ${element}")
        return list.add(element)
    }

}