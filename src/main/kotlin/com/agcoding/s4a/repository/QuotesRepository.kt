package com.agcoding.s4a.repository

import com.agcoding.s4a.QuoteDto
import org.springframework.stereotype.Repository
// Purpose of talking one or more data sources and properly provide the data
@Repository
class QuotesRepository {

    private val quotes : MutableList<QuoteDto> = mutableListOf()

    fun getQuotes() : MutableList<QuoteDto> = quotes

    fun insertQuote(quote: QuoteDto) :QuoteDto {
        quotes.add(quote)
        return quote
    }

    fun updateQuote(quote: QuoteDto) : QuoteDto {
         val index = quotes.indexOfFirst { it.id == quote.id }
        quotes[index] = quote
        return quote
    }

    fun deleteQuote(id: Long)  : Boolean {
        val quoteToDelete = quotes.find { it.id == id }
        return if (quoteToDelete != null) {
            quotes.remove(quoteToDelete)
            true
        }
        else{
            false
        }
    }
}