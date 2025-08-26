package com.agcoding.s4a.data

import jakarta.validation.constraints.Pattern
import org.hibernate.validator.constraints.Length

// Quote Data Transfer Object
data class QuoteDto (
    val id : Long,
    @field:Length(
        min = 5,
        max = 500,
        message = "Quote id must be between 5 and 100 characters")
    val content : String,
    @field:Pattern(
        regexp = "\\b[a-zA-Z]+\\b(?:\\s+\\b[a-zA-Z]+\\b)+",
        message = "Author must have First Name and Last Name"
    )
    val author : String,
)