package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.CurrencyNameInfo;
import com.example.demo.response.ResponseBean;
import com.example.demo.service.CurrencyNameInfoService;

@RestController
@RequestMapping("/api")
public class CurrencyNameInfoController {

    @Autowired
    CurrencyNameInfoService currencyNameInfoService;	
	
    @RequestMapping(value="/currencys", method=RequestMethod.POST)
    public ResponseBean createCurrencyNameInfo(@RequestBody CurrencyNameInfo currencyChineseName) {
        return currencyNameInfoService.createCurrencyChineseName(currencyChineseName);
    }
    
    @RequestMapping(value="/currencys", method=RequestMethod.GET)
    public ResponseBean readCurrencyNameInfos() {
        return currencyNameInfoService.getCurrencyNameInfos();
    }

    @RequestMapping(value="/currencys/{currencyId}", method=RequestMethod.PUT)
    public ResponseBean updateEmployees(@PathVariable(value = "currencyId") String currencyId, @RequestBody CurrencyNameInfo currencyNameInfo) {
        return currencyNameInfoService.updateCurrencyNameInfo(currencyId, currencyNameInfo);
    }

    @RequestMapping(value="/currencys/{currencyId}", method=RequestMethod.DELETE)
    public ResponseBean deleteEmployees(@PathVariable(value = "currencyId") String currencyId) {
    	return currencyNameInfoService.deleteCurrencyNameInfo(currencyId);
    }
 
}
