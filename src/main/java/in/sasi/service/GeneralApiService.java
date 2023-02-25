package in.sasi.service;

import java.util.Date;

import in.sasi.data.ExchangeInfoApiResponseData;

public interface GeneralApiService {

	boolean ping();
	
	Date getServerTime();
	
	String getSystemStatus();

	ExchangeInfoApiResponseData getExchangeInfo();
}
