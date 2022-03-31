package com.ysjleader.tobyspringkotlin.exception.handler

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class BaseExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [Throwable::class])
    fun handleException(e: Throwable): ResponseEntity<ErrorResponse> {
        return ResponseEntity
            .status(400)
            .body(ErrorResponse(e.message!!))

    }
}