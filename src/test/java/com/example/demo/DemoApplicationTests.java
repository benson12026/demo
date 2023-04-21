package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.repository.CurrencyNameInfo;
import com.example.demo.response.ResponseBean;
import com.example.demo.service.CoindeskService;
import com.example.demo.service.CurrencyNameInfoService;
import com.exmple.demo.model.CurrencyNameInfoList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	CoindeskService coindeskService;

	@Autowired
	CurrencyNameInfoService currencyNameInfoService;

	// 1. 測試呼叫查詢幣別對應表資料 API,並顯示其內容。
	@Test
	void readCurrencyNameInfosTest() throws Exception {

		System.out.println("1. 測試呼叫查詢幣別對應表資料 API,並顯示其內容。");
		
		ResponseBean result = currencyNameInfoService.getCurrencyNameInfos();
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(result);

		System.out.println("result=" + json);

	}

	// 2. 測試呼叫新增幣別對應表資料 API。
	@Test
	void createCurrencyChineseNameTest() throws Exception {

		System.out.println("2. 測試呼叫新增幣別對應表資料 API。");
		
		CurrencyNameInfo currencyChineseName = new CurrencyNameInfo();
		currencyChineseName.setCurrencyId("TWD");
		currencyChineseName.setCurrencyName("新臺幣");

		currencyNameInfoService.createCurrencyChineseName(currencyChineseName);
		ResponseBean result = currencyNameInfoService.getCurrencyNameInfos();
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(result);

		System.out.println("result=" + json);

	}

	// 3. 測試呼叫更新幣別對應表資料 API,並顯示其內容。
	@Test
	void updateCurrencyChineseNameTest() throws Exception {

		System.out.println("3. 測試呼叫更新幣別對應表資料 API,並顯示其內容。");
		
		String currencyId = "USD";
		CurrencyNameInfo currencyNameInfo = new CurrencyNameInfo();
		currencyNameInfo.setCurrencyId("USD");
		currencyNameInfo.setCurrencyName("美金2");

		ResponseBean result = currencyNameInfoService.updateCurrencyNameInfo(currencyId, currencyNameInfo);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(result);

		System.out.println("result=" + json);

	}

	// 4. 測試呼叫刪除幣別對應表資料 API。
	@Test
	void deleteCurrencyChineseNameTest() throws Exception {

		System.out.println("4. 測試呼叫刪除幣別對應表資料 API。");
		
		String currencyId = "USD";

		ResponseBean result = currencyNameInfoService.deleteCurrencyNameInfo(currencyId);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(result);

		System.out.println("result=" + json);

	}

	// 5. 測試呼叫 coindesk API,並顯示其內容。
	@Test
	void readCoindeskTest() throws Exception {

		System.out.println("5. 測試呼叫 coindesk API,並顯示其內容。");
		
		ResponseBean result = coindeskService.readCoindesk();
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(result);

		System.out.println("result=" + json);

	}

	// 6. 測試呼叫資料轉換的 API,並顯示其內容。
	@Test
	void readCoindeskInfoTest() throws Exception {

		System.out.println("6. 測試呼叫資料轉換的 API,並顯示其內容。");
		
		ResponseBean result = coindeskService
				.readCoindeskInfo((CurrencyNameInfoList) currencyNameInfoService.getCurrencyNameInfos().getData());
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(result);

		System.out.println("result=" + json);

	}

}
