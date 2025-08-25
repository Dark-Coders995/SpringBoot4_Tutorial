package com.agcoding.s4a


import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice // Advisor to handle Exception Help to define custom exception
class QuotesExceptionHandler{
    
    @ExceptionHandler(QuotesNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun onQuoteNotFound(e : QuotesNotFoundException) : Map<String, String?> = mapOf(
        "errorCode" to "Quote not found",
        "message" to e.message
    )
}