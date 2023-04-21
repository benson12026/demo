package com.exmple.demo.coindesk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bpi {

	@JsonProperty("USD")
	private Usd usd;
	
	@JsonProperty("GBP")
	private Gbp gbp;
	
	@JsonProperty("EUR")
	private Eur eur;

	public Usd getUsd() {
		return usd;
	}

	public void setUsd(Usd usd) {
		this.usd = usd;
	}

	public Gbp getGbp() {
		return gbp;
	}

	public void setGbp(Gbp gbp) {
		this.gbp = gbp;
	}

	public Eur getEur() {
		return eur;
	}

	public void setEur(Eur eur) {
		this.eur = eur;
	}
	
}
