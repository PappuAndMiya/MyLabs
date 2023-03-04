package in.sasi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.sasi.constant.MyLabsConstant;
import in.sasi.util.SystemUtil;

public class AbstractApiService {

	private static final String ENDPOINT_HOST = SystemUtil.getProperty(MyLabsConstant.ENDPOINT_HOST);

	// General API
	private static final String ENDPOINT_PING = SystemUtil.getProperty(MyLabsConstant.ENDPOINT_PING);
	private static final String ENDPOINT_SERVER_TIME = SystemUtil.getProperty(MyLabsConstant.ENDPOINT_SERVER_TIME);
	private static final String ENDPOINT_SYSTEM_STATUS = SystemUtil.getProperty(MyLabsConstant.ENDPOINT_SYSTEM_STATUS);
	private static final String ENDPOINT_EXCHANGE_INFO = SystemUtil.getProperty(MyLabsConstant.ENDPOINT_EXCHANGE_INFO);

	// Public API
	private static final String ENDPOINT_TICKERS = SystemUtil.getProperty(MyLabsConstant.ENDPOINT_TICKERS);
	private static final String ENDPOINT_TICKER = SystemUtil.getProperty(MyLabsConstant.ENDPOINT_TICKER);
	
	

	private static RequestConfig requestConfig;
	private static PoolingHttpClientConnectionManager connectionManager;

	protected RestTemplate getRestTemplate() {
		CloseableHttpClient httpClient = HttpClientBuilder
				.create()
				.setConnectionManager(getOrCreatePoolingHttpClientConnectionManager())
				.setDefaultRequestConfig(getOrCreateRequestConfig())
				.build();
		ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
		RestTemplate template = new RestTemplate(requestFactory);
		template.setMessageConverters(getMessageConverters());
		return template;
	}

	private List<HttpMessageConverter<?>> getMessageConverters() {
		ObjectMapper objectMapper = new ObjectMapper();

		List<HttpMessageConverter<?>> converters = new ArrayList<>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(objectMapper);
		converters.add(converter);
		return converters;
	}

	private RequestConfig getOrCreateRequestConfig() {
		if (null == requestConfig) {
			requestConfig = RequestConfig
					.custom()
					.setConnectionRequestTimeout(3000) // timeout to get connection from pool
					.setSocketTimeout(3000) // standard connection timeout
					.setConnectTimeout(3000) // standard connection timeout
					.build();
		}
		return requestConfig;
	}

	private PoolingHttpClientConnectionManager getOrCreatePoolingHttpClientConnectionManager() {
		if (null != connectionManager) {
			connectionManager = new PoolingHttpClientConnectionManager();
			connectionManager.setMaxTotal(20);
			connectionManager.setDefaultMaxPerRoute(20);
		}
		return connectionManager;
	}

	protected String getPingEndPoint() {
		return ENDPOINT_HOST + ENDPOINT_PING;
	}

	protected String getServerTimeEndPoint() {
		return ENDPOINT_HOST + ENDPOINT_SERVER_TIME;
	}
	
	protected String getSystemStatusEndPoint() {
		return ENDPOINT_HOST + ENDPOINT_SYSTEM_STATUS;
	}
	
	protected String getExchangeInfoEndPoint() {
		return ENDPOINT_HOST + ENDPOINT_EXCHANGE_INFO;
	}
	
	protected String getTickersEndPoint() {
		return ENDPOINT_HOST + ENDPOINT_TICKERS;
	}
	
	protected String getTickerEndPoint(String symbol) {
		return ENDPOINT_HOST + ENDPOINT_TICKER + symbol;
	}
	
}
