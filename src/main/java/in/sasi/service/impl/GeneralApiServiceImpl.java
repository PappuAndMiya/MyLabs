package in.sasi.service.impl;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import in.sasi.data.ExchangeInfoApiResponseData;
import in.sasi.data.ServerTimeApiResponseData;
import in.sasi.data.SystemStatusApiResponseData;
import in.sasi.service.GeneralApiService;

public class GeneralApiServiceImpl extends AbstractApiService implements GeneralApiService {

	@Override
	public boolean ping() {
		RestTemplate restTemplate = getRestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(getPingEndPoint(), String.class);
		return HttpStatus.OK.equals(responseEntity.getStatusCode());
	}

	@Override
	public Date getServerTime() {
		RestTemplate restTemplate = getRestTemplate();
		ResponseEntity<ServerTimeApiResponseData> responseEntity = restTemplate.getForEntity(getServerTimeEndPoint(), ServerTimeApiResponseData.class);
		return new Date(responseEntity.getBody().getServerTime());
	}

	@Override
	public String getSystemStatus() {
		RestTemplate restTemplate = getRestTemplate();
		ResponseEntity<SystemStatusApiResponseData> responseEntity = restTemplate.getForEntity(getSystemStatusEndPoint(), SystemStatusApiResponseData.class);
		return responseEntity.getBody().getStatus();
	}
	
	@Override
	public ExchangeInfoApiResponseData getExchangeInfo() {
		RestTemplate restTemplate = getRestTemplate();
		ResponseEntity<ExchangeInfoApiResponseData> responseEntity = restTemplate.getForEntity(getExchangeInfoEndPoint(), ExchangeInfoApiResponseData.class);
		return responseEntity.getBody();
	}

}
