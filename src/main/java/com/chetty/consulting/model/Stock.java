package com.chetty.consulting.model;

import java.util.Date;

public class Stock {
	// Date, Ticker, Open, High, Low, Close, Volume for the day
	
	String date;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	String ticker;
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	
	double open;
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	
	double high;
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	
	double low;
	public double getLow() {
		return low;
	}
	public void setLow(double low) {
		this.low = low;
	}
	
	double close;
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		this.close = close;
	}
	
	long volume;
	public long getVolume() {
		return volume;
	}
	public void setVolume(long volume) {
		this.volume = volume;
	}
	
	
	public Stock(String date, String ticker, double open, double high, double low, double close, long volume) {
		super();
		this.date = date;
		this.ticker = ticker;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
	}
	
	public Stock(String date, String ticker, String open, String high, String low, String close, String volume) {
		super();
		this.date = date;
		this.ticker = ticker;
		this.open = Double.parseDouble(open);
		this.high = Double.parseDouble(high);
		this.low = Double.parseDouble(low);
		this.close = Double.parseDouble(close);
		this.volume = Long.parseLong(volume);
	}
}
