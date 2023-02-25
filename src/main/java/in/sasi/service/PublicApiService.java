package in.sasi.service;

import java.util.List;

import in.sasi.data.TickerApiResponseData;

public interface PublicApiService {

	List<TickerApiResponseData> getTickers();
	
	TickerApiResponseData getTicker(String symbol);

	List<TickerApiResponseData> getTickersByQuoteAsset(String quoteAsset);
	
}
