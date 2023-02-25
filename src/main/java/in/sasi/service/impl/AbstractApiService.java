package in.sasi.service.impl;

import org.springframework.web.client.RestTemplate;

public class AbstractApiService {

	private static final String HOST = "";
	
	private static final String ENDPOINT_PING = "/sapi/v1/ping";
	
	private static final String ENDPOINT_SERVER_TIME = "/sapi/v1/time";
	
	protected String getPingEndPoint() {
		return HOST + ENDPOINT_PING;
	}
	
	protected String getServerTimeEndPoint() {
		return HOST + ENDPOINT_SERVER_TIME;
	}
	
	protected RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
}
