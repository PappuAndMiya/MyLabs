package in.sasi.service;

import java.util.List;

import in.sasi.data.TickerApiResponseData;

public interface PublicApiService {

	List<TickerApiResponseData> getTickers();
	
	List<TickerApiResponseData> getTickersByQuoteAsset(String quoteAsset);

	TickerApiResponseData getTicker(String symbol);
	
}
