package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.response.ResponseBean;
import com.example.demo.service.CoindeskService;
import com.example.demo.service.CurrencyNameInfoService;
import com.exmple.demo.model.CurrencyNameInfoList;

@RestController
@RequestMapping("/api")
public class CoindeskController {

    @Autowired
    CoindeskService coindeskService;	
    
    @Autowired
    CurrencyNameInfoService currencyNameInfoService;	 
    
    @RequestMapping(value="/coindesk", method=RequestMethod.GET)
    public ResponseBean readCoindesk() {
    	return coindeskService.readCoindesk();
    }
    
    @RequestMapping(value="/coindeskInfo", method=RequestMethod.GET)
    public ResponseBean readCoindeskInfo() {
    	
    	return coindeskService.readCoindeskInfo( (CurrencyNameInfoList)currencyNameInfoService.getCurrencyNameInfos().getData() );
    }
	
}
