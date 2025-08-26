package com.agcoding.s4a.config

import org.springframework.boot.context.properties.ConfigurationProperties


@ConfigurationProperties(prefix = "quotes")
data class QuoteConfig(
    val search : SearchConfig,
    val validation : ValidationConfig
){
    data class SearchConfig(
        val ignoreCase : Boolean = true,
        val minLength : Int = 3,
    )
    data class ValidationConfig(
        val minContentLength : Int = 3,
        val maxContentLength : Int = 500,
        val requireAuthor : Boolean = true,
        val allowedCategories : List<String> = emptyList(),
    )
}