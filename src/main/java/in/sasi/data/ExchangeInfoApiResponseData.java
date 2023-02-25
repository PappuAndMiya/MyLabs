package in.sasi.data;

import java.util.ArrayList;
import java.util.List;

public class ExchangeInfoApiResponseData {
	private List<ExchangeInfoApiSymbolResponseData> symbols = new ArrayList<ExchangeInfoApiSymbolResponseData>();
	private Integer serverTime;
	private String timeZone;

	public List<ExchangeInfoApiSymbolResponseData> getSymbols() {
		return symbols;
	}

	public void setSymbols(List<ExchangeInfoApiSymbolResponseData> symbols) {
		this.symbols = symbols;
	}

	public Integer getServerTime() {
		return serverTime;
	}

	public void setServerTime(Integer serverTime) {
		this.serverTime = serverTime;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
}
