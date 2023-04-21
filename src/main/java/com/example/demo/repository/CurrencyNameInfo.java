package com.example.demo.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CURRENCY_NAME_INFO")
public class CurrencyNameInfo {

	@Id
	@Column(name="CURRENCY_ID")
	private String currencyId;
	
	@Column(name="CURRENCY_NAME")
	private String currencyName;

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

}
