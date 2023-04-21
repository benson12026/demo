package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CurrencyNameInfo;
import com.example.demo.repository.CurrencyNameInfoRepository;
import com.example.demo.response.ResponseBean;
import com.exmple.demo.model.CurrencyNameInfoList;

@Service
public class CurrencyNameInfoService {

	@Autowired
	CurrencyNameInfoRepository currencyNameInfoRepository;

	// CREATE
	public ResponseBean createCurrencyChineseName(CurrencyNameInfo currencyNameInfo) {

		ResponseBean response = new ResponseBean();

		try {

			CurrencyNameInfo info = currencyNameInfoRepository.save(currencyNameInfo);
			response.setData(info);

		} catch (Exception e) {
			e.printStackTrace();
			response.setCode("9999");
			response.setMessage("系統錯誤");
		}

		return response;
	}

	// READ
	public ResponseBean getCurrencyNameInfos() {

		ResponseBean response = new ResponseBean();

		List<CurrencyNameInfo> list = currencyNameInfoRepository.findAll();

		CurrencyNameInfoList currencyNameInfoList = new CurrencyNameInfoList();
		currencyNameInfoList.setCurrencyNameInfoList(list);

		response.setData(currencyNameInfoList);

		return response;
	}

	// DELETE
	public ResponseBean deleteCurrencyNameInfo(String currencyName) {

		ResponseBean response = new ResponseBean();

		try {
			currencyNameInfoRepository.deleteById(currencyName);
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode("9999");
			response.setMessage("系統錯誤");
		}

		return response;
	}

	// UPDATE
	public ResponseBean updateCurrencyNameInfo(String currencyName, CurrencyNameInfo currencyNameInfo) {

		ResponseBean response = new ResponseBean();

		try {
			CurrencyNameInfo currency = currencyNameInfoRepository.findById(currencyName).get();
			currency.setCurrencyId(currencyNameInfo.getCurrencyId());
			currency.setCurrencyName(currencyNameInfo.getCurrencyName());
			currencyNameInfoRepository.save(currency);

			response.setData((CurrencyNameInfoList) getCurrencyNameInfos().getData());

		} catch (Exception e) {
			e.printStackTrace();
			response.setCode("9999");
			response.setMessage("系統錯誤");
		}

		return response;
	}

}
