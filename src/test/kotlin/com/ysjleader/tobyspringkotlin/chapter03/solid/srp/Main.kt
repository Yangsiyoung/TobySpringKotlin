package com.ysjleader.tobyspringkotlin.chapter03.solid.srp

fun main() {
    val userService = UserService()
    userService.createUser()
    userService.updateUser()

    val orderService = OrderService()
    orderService.cancelOrder()
    orderService.cancelOrder()
}