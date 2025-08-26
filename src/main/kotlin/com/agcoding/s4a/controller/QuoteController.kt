package com.agcoding.s4a.controller

import com.agcoding.s4a.data.QuoteDto
import com.agcoding.s4a.service.QuotesService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/quotes")
class  QuoteController(
    private val quoteService : QuotesService
) {
    @GetMapping
    fun loadQuotes(
        @RequestParam("q" , required = false) query : String? ,
    ) : List<QuoteDto>{
        return quoteService.getQuotes()
    }

    @PostMapping
    fun saveQuote(
        @Valid @RequestBody quoteDto: QuoteDto
    ) : QuoteDto {
        return quoteService.insertQuote(quoteDto)
    }

    @PutMapping
    fun updateQuote(

        @Valid @RequestBody quoteDto: QuoteDto
    ) : QuoteDto {
        return quoteService.updateQuote(quoteDto)
    }

    @DeleteMapping("/{id}")
    fun deleteQuote(
        @PathVariable("id") id : Long ,
    ) {
        return quoteService.deleteQuote(id)
    }
}