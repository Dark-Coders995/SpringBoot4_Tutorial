package com.agcoding.s4a.util


import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
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

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun onValidationFailed(e: MethodArgumentNotValidException) : ResponseEntity<Map<String , Any>>{
        val map = mutableMapOf<String , Any>()
        e.bindingResult.fieldErrors.forEach { fieldError ->
            map[fieldError.field] = fieldError.defaultMessage ?: "Validation failed"
        }
        return ResponseEntity
            .badRequest()
            .body(map)
    }
}