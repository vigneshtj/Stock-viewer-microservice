package com.share.view.stockservice.resource;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@RestController
@RequestMapping("/rest/stock")
public class StockController {
	
	@Autowired
    RestTemplate restTemplate;
	
    @GetMapping("/{username}")
    public List<Quote> getStock(@PathVariable("username") final String userName) {
    	System.err.println(userName);
    	ResponseEntity<List<String>> quoteResponse = restTemplate.exchange("http://DB-SERVICE/rest/db/" + userName, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<String>>(){});


        List<String> quotes = quoteResponse.getBody();
        return quotes
        		.stream()
                .map(quote -> {
     //               Stock stock = getStockPrice(quote);
      //              return new Quote(quote, stock.getQuote().getPrice());
                	return new Quote(quote, 100.00);
                })
                .collect(Collectors.toList());
    }
	
	/*
	 * private Stock getStockPrice(String quote) { try { System.err.println("try");
	 * return YahooFinance.get(quote); } catch (IOException e) {
	 * System.err.println("catch"); e.printStackTrace(); return new Stock(quote); }
	 * }
	 */
	 
	  private class Quote { private String quote; private double price;
	  
	  public Quote(String quote, double price) { this.quote = quote; this.price
	  = price; }
	  
	  public String getQuote() { return quote; }
	  
	  public void setQuote(String quote) { this.quote = quote; }
	  
	  public double getPrice() { return price; }
	  
	  public void setPrice(double price) { this.price = price; } }
	 
    
}
