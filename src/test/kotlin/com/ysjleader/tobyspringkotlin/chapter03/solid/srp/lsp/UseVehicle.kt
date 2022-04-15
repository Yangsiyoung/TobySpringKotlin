package com.ysjleader.tobyspringkotlin.chapter03.solid.srp.lsp

class UseVehicle(
    private val vehicle: Vehicle
) {

    fun logic01() {
        vehicle.goStraight() // 앞으로감
    }
}