package com.agcoding.s4a

import com.agcoding.s4a.service.QuotesService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/quotes")
class  QuoteController(
    private val quoteService : QuotesService
) {
    @GetMapping
    fun loadQuotes(
        @RequestParam("q" , required = false) query : String?,
    ) : List<QuoteDto>{
        return quoteService.getQuotes()
    }

    @PostMapping
    fun saveQuote(@RequestBody quoteDto: QuoteDto) : QuoteDto {
        return quoteService.insertQuote(quoteDto)
    }

    @PutMapping
    fun updateQuote(@RequestBody quoteDto: QuoteDto) : QuoteDto {
        return quoteService.updateQuote(quoteDto)
    }

    @DeleteMapping("/{id}")
    fun deleteQuote(
        @PathVariable("id") id : Long ,
    ) {
        return quoteService.deleteQuote(id)
    }
}