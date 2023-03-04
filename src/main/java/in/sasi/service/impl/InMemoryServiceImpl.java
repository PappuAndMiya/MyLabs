package in.sasi.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import in.sasi.constant.MyLabsConstant;
import in.sasi.data.TickerApiResponseData;
import in.sasi.service.GeneralApiService;
import in.sasi.service.InMemoryService;
import in.sasi.service.PublicApiService;
import in.sasi.util.SystemUtil;

public class InMemoryServiceImpl implements InMemoryService {

	private static String systemStatus = StringUtils.EMPTY;
	private static List<TickerApiResponseData> tickers = new ArrayList<TickerApiResponseData>();
	private static Map<String, TickerApiResponseData> ticker = new HashMap<String, TickerApiResponseData>();
	
	private GeneralApiService generalApiService;
	private PublicApiService publicApiService;

	@Override
	public void refreshSystemStatus() {
		systemStatus = generalApiService.getSystemStatus();
	}
	
	@Override
	public void refreshTickers() {
		tickers = publicApiService.getTickersByQuoteAsset(SystemUtil.getProperty(MyLabsConstant.PREFERRED_TRADE_CURRENCY));
	}
	
	@Override
	public void refreshTicker(String symbol) {
		ticker.put(symbol, publicApiService.getTicker(symbol));
	}

	// variable getter methods
	public static String getSystemStatus() {
		return systemStatus;
	}

	public static List<TickerApiResponseData> getTickers() {
		return tickers;
	}

	//service setter methods
	public void setGeneralApiService(GeneralApiService generalApiService) {
		this.generalApiService = generalApiService;
	}

	public void setPublicApiService(PublicApiService publicApiService) {
		this.publicApiService = publicApiService;
	}

}
