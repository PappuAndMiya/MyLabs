package in.sasi.data;

import java.util.ArrayList;
import java.util.List;

public class ExchangeInfoApiSymbolResponseData {
	private String symbol;
	private String status;
	private String baseAsset;
	private String quoteAsset;
	private Integer baseAssetPrecision;
	private Integer quoteAssetPrecision;
	private List<String> orderTypes = new ArrayList<String>();
	private Boolean isSpotTradingAllowed;
	private List<ExchangeInfoApiSymbolFilterResponseData> filters = new ArrayList<>();

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBaseAsset() {
		return baseAsset;
	}

	public void setBaseAsset(String baseAsset) {
		this.baseAsset = baseAsset;
	}

	public String getQuoteAsset() {
		return quoteAsset;
	}

	public void setQuoteAsset(String quoteAsset) {
		this.quoteAsset = quoteAsset;
	}

	public Integer getBaseAssetPrecision() {
		return baseAssetPrecision;
	}

	public void setBaseAssetPrecision(Integer baseAssetPrecision) {
		this.baseAssetPrecision = baseAssetPrecision;
	}

	public Integer getQuoteAssetPrecision() {
		return quoteAssetPrecision;
	}

	public void setQuoteAssetPrecision(Integer quoteAssetPrecision) {
		this.quoteAssetPrecision = quoteAssetPrecision;
	}

	public List<String> getOrderTypes() {
		return orderTypes;
	}

	public void setOrderTypes(List<String> orderTypes) {
		this.orderTypes = orderTypes;
	}

	public Boolean getIsSpotTradingAllowed() {
		return isSpotTradingAllowed;
	}

	public void setIsSpotTradingAllowed(Boolean isSpotTradingAllowed) {
		this.isSpotTradingAllowed = isSpotTradingAllowed;
	}

	public List<ExchangeInfoApiSymbolFilterResponseData> getFilters() {
		return filters;
	}

	public void setFilters(List<ExchangeInfoApiSymbolFilterResponseData> filters) {
		this.filters = filters;
	}
}
