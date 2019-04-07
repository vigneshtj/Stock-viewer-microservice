package com.share.view.dbservice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/db")
public class DBServiceController {
	@Autowired
	  private QuotesRepository quotesRepository;

	    public DBServiceController(QuotesRepository quotesRepository) {
	        this.quotesRepository = quotesRepository;
	    }
	    
	    @RequestMapping("/{username}")
	    public List<String> getQuotes(@PathVariable("username") final String username) {
	        return getQuotesByUserName(username);
	    }
	    
	    @RequestMapping(method=RequestMethod.POST, value="/add")
	    public List<String> add(@RequestBody final Quotes quotes) {
	    	  quotes.getQuotes()
	                .stream()
	                .map(quote -> new Quote(quotes.getUserName(), quote))
	                .forEach(quote -> quotesRepository.save(quote));
	        return getQuotesByUserName(quotes.getUserName());
	    }
	    
	   // @RequestMapping(method=RequestMethod.POST, value="/delete/{username}")
	    @PostMapping("/delete/{username}")
	    public List<String> delete(@PathVariable("username") final String username) {
	        List<Quote> quotes = quotesRepository.findByUserName(username);
	        
	        quotesRepository.deleteAll(quotes);
	        //quotes.forEach(quote->quotesRepository.delete(quote))
	        return getQuotesByUserName(username);
	    }
	    
	    private List<String> getQuotesByUserName(@PathVariable("username") String username) {
	        return quotesRepository.findByUserName(username)
	                .stream()
	                .map(Quote::getQuote)
	                .collect(Collectors.toList());
	    }
	    
}
