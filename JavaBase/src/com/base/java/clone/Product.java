package com.base.java.clone;

import java.util.Collections;
import java.util.List;

public class Product {
	private long id;
	private List<StockQuote> list;

	Product (long id){this.id = id;}
	
	public StockQuote getStockQuote(int index) {
		return list.get(index);
	}
	
	public List<StockQuote> getList(){
		return Collections.unmodifiableList(list);
	}
	
	public void addStockQuote(StockQuote stockQuote){
		list.add(stockQuote);
	}

	public void setList(List<StockQuote> list) {
		this.list = list;
	}
}
