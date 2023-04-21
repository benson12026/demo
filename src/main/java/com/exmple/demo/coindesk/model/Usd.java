package com.exmple.demo.coindesk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Usd {

	@JsonProperty("code")
	private String code;
	
	@JsonProperty("symbol")
	private String symbol;
	
	@JsonProperty("rate")
	private String rate;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("rate_float")
	private Float rateFloat;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getRateFloat() {
		return rateFloat;
	}

	public void setRateFloat(Float rateFloat) {
		this.rateFloat = rateFloat;
	}
	
}
