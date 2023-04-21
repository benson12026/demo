package com.example.demo.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.repository.CurrencyNameInfo;
import com.example.demo.response.ResponseBean;
import com.exmple.demo.coindesk.model.Coindesk;
import com.exmple.demo.model.CoindeskInfo;
import com.exmple.demo.model.CoindeskInfoList;
import com.exmple.demo.model.CurrencyNameInfoList;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CoindeskService {

	public ResponseBean readCoindesk() {
		
		ResponseBean response = new ResponseBean();
		
		try
		{
			
			RestTemplate restTemplate=new RestTemplate();
			ResponseEntity<String> responseEntity = restTemplate.getForEntity("https://api.coindesk.com/v1/bpi/currentprice.json", String.class);
			ObjectMapper objectMapper = new ObjectMapper();
			Coindesk coindesk = objectMapper.readValue(responseEntity.getBody(), Coindesk.class);
			response.setData(coindesk);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			response.setCode("9999");
			response.setMessage("系統錯誤");
		}


	    return response;                                
	}
	
	public ResponseBean readCoindeskInfo( CurrencyNameInfoList currencyList ) {
		
		ResponseBean response = new ResponseBean();
		
		try
		{
			
			RestTemplate restTemplate=new RestTemplate();
			ResponseEntity<String> responseEntity = restTemplate.getForEntity("https://api.coindesk.com/v1/bpi/currentprice.json", String.class);
			ObjectMapper objectMapper = new ObjectMapper();
			Coindesk coindesk = objectMapper.readValue(responseEntity.getBody(), Coindesk.class);
			
			String usdCode = coindesk.getBpi().getUsd().getCode();
			String gbpCode = coindesk.getBpi().getGbp().getCode();
			String eurCode = coindesk.getBpi().getEur().getCode();
			
			List<CoindeskInfo> list = new ArrayList<CoindeskInfo>();
			
			for( CurrencyNameInfo currency : currencyList.getCurrencyNameInfoList() )
			{
				
				CoindeskInfo coindeskInfo = new CoindeskInfo();
				
				String code = "";
				
				if( currency.getCurrencyId().equals(usdCode) )
				{
					code = usdCode;
					
				}
				else if( currency.getCurrencyId().equals(gbpCode) )
				{
					code = gbpCode;
				}
				else if( currency.getCurrencyId().equals(eurCode) )
				{
					code = eurCode;
				}
				
				if( !code.isBlank() )
				{
					setCoindeskInfo(coindeskInfo, currency.getCurrencyName(), coindesk, code);
					list.add(coindeskInfo);
				}
				
			}
			
			CoindeskInfoList coindeskInfoList = new CoindeskInfoList();
			coindeskInfoList.setCoindeskInfoList(list);
			response.setData(coindeskInfoList);

		}
		catch(Exception e)
		{
			e.printStackTrace();
			response.setCode("9999");
			response.setMessage("系統錯誤");
		}


	    return response;                                
	}
	
	public CoindeskInfo setCoindeskInfo( CoindeskInfo coindeskInfo, String CurrencyName, Coindesk coindesk, String CurrencyId )
	{
		
		String usdCode = coindesk.getBpi().getUsd().getCode();
		String gbpCode = coindesk.getBpi().getGbp().getCode();
		String eurCode = coindesk.getBpi().getEur().getCode();
		
		String code = "";
		String rate = "";
		
		if( CurrencyId.equals(usdCode) )
		{
			code = coindesk.getBpi().getUsd().getCode();
			rate = coindesk.getBpi().getUsd().getRate();
		}
		else if( CurrencyId.equals(gbpCode) )
		{
			code = coindesk.getBpi().getGbp().getCode();
			rate = coindesk.getBpi().getGbp().getRate();
		}
		else if( CurrencyId.equals(eurCode) )
		{
			code = coindesk.getBpi().getEur().getCode();
			rate = coindesk.getBpi().getEur().getRate();
		}
		
		coindeskInfo.setCurrencyId(code);
		coindeskInfo.setCurrencyName(CurrencyName);
		coindeskInfo.setRate(rate);
		coindeskInfo.setUpdateDate(formatDate(coindesk.getTime().getUpdated()));
		
		return coindeskInfo;
	}
	
	public String formatDate(String date)
	{
		
		String resultDate = "";
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:sssXXX");
		Date result;
		try {				   
		    result = df.parse("2023-04-19T13:17:00+00:00");
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		    resultDate = sdf.format(result);
		   
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return resultDate;
		
	}
	
}
