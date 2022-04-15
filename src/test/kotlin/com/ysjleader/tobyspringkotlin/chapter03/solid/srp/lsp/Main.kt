package com.ysjleader.tobyspringkotlin.chapter03.solid.srp.lsp

fun main() {
    val useVehicle = UseVehicle(vehicle = StrangeVehicle())
    useVehicle.logic01()
}