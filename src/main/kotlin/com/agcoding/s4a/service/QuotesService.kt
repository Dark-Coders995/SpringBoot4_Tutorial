package com.agcoding.s4a.service

import com.agcoding.s4a.data.QuoteDto
import com.agcoding.s4a.util.QuotesNotFoundException
import com.agcoding.s4a.config.QuoteConfig
import com.agcoding.s4a.repository.QuotesRepository
import org.springframework.stereotype.Service


// Middle man between Repository and Rest Controller -> Uses  business logic if  data is multiple data sources
@Service
class QuotesService(
    private  val quotesRepository : QuotesRepository ,
    private  val quoteConfig : QuoteConfig ,
) {
    fun insertQuote(quotes : QuoteDto) : QuoteDto{
        return quotesRepository.insertQuote(quotes)
    }

    fun updateQuote(quote : QuoteDto) : QuoteDto{
        return quotesRepository.updateQuote(quote)
    }

    fun deleteQuote(id : Long){
        if(!quotesRepository.deleteQuote(id)){
            throw QuotesNotFoundException(id)
        }
    }

    fun getQuotes() : List<QuoteDto> = quotesRepository.getQuotes()
}