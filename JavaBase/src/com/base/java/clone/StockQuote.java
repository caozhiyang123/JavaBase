package com.base.java.clone;

import java.time.LocalDateTime;

class StockQuote implements Cloneable{
	private  String name;
	private  LocalDateTime time;
	private  Double price;  
    public StockQuote(String n, LocalDateTime t, Double p) {
        name = n;
        time = t;
        price = p;
    }

    @Override
    public final StockQuote clone(){
    	try {
			return (StockQuote)super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "StockQuote [name=" + name + ", time=" + time + ", price=" + price + "]";
	}
}