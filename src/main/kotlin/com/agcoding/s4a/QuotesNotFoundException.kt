package com.agcoding.s4a

class QuotesNotFoundException(
    private val id: Long
) : RuntimeException(
    "A quote with ID $id was not found"
)