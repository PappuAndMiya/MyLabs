package in.sasi.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import in.sasi.data.TickerApiResponseData;
import in.sasi.service.PublicApiService;

public class PublicApiServiceImpl extends AbstractApiService implements PublicApiService {

	@Override
	public List<TickerApiResponseData> getTickers() {
		RestTemplate restTemplate = getRestTemplate();
		ResponseEntity<TickerApiResponseData[]> responseEntity = restTemplate.getForEntity(getTickersEndPoint(),
				TickerApiResponseData[].class);

		return Arrays.asList(responseEntity.getBody());
	}

	@Override
	public List<TickerApiResponseData> getTickersByQuoteAsset(String quoteAsset) {
		List<TickerApiResponseData> tickersByQuoteAsset = getTickers().stream().filter(ticker -> quoteAsset.equals(ticker.getQuoteAsset()))
		.collect(Collectors.toList());
		
		Collections.sort(tickersByQuoteAsset, new Comparator<TickerApiResponseData>() {
	        @Override
	        public int compare(TickerApiResponseData o1, TickerApiResponseData o2) {
	            return Double.compare(o2.getChange24Hrs(), o1.getChange24Hrs());
	        }           
	    });
		
		return tickersByQuoteAsset;
	}

	@Override
	public TickerApiResponseData getTicker(String symbol) {
		RestTemplate restTemplate = getRestTemplate();
		ResponseEntity<TickerApiResponseData> responseEntity = restTemplate.getForEntity(getTickerEndPoint(symbol),
				TickerApiResponseData.class);
		return responseEntity.getBody();
	}

}
