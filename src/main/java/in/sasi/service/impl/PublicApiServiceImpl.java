package in.sasi.service.impl;

import java.util.Arrays;
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
		return getTickers().stream().filter(ticker -> quoteAsset.equals(ticker.getQuoteAsset()))
				.collect(Collectors.toList());
	}

	@Override
	public TickerApiResponseData getTicker(String symbol) {
		return null;
	}

}
