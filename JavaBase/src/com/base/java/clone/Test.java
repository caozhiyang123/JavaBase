package com.base.java.clone;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		List<StockQuote> resource = new ArrayList<StockQuote>();
		resource.add(new StockQuote("a", LocalDateTime.now(), 1.1));
		resource.add(new StockQuote("b", LocalDateTime.now(ZoneId.systemDefault()) , 1.1));
		resource.add(new StockQuote("c", LocalDateTime.now(Clock.systemDefaultZone()) , 1.1));
		resource.add(new StockQuote("d", LocalDateTime.now(Clock.systemUTC()) , 1.1));
		
		//ArrayList<StockQuote> stocks = list.stream().map(s->s.clone()).collect(Collectors.toCollection(ArrayList::new));
		List<StockQuote> stocks = resource.stream().map(s->s.clone()).collect(Collectors.toList());
		stocks.get(0).setName("aaa");
		System.out.println(resource.toString());
		System.out.println(stocks.toString());
	}
}
