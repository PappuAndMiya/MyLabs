package in.sasi.data;

import org.springframework.util.NumberUtils;

public class TickerApiResponseData {
	private String symbol;
	private String baseAsset;
	private String quoteAsset;
	private String openPrice;
	private String lowPrice;
	private String highPrice;
	private String lastPrice;
	private String volume;
	private String bidPrice;
	private String askPrice;
	private long at;
	
	private double change24Hrs;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
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

	public String getOpenPrice() {
		return openPrice;
	}

	public void setOpenPrice(String openPrice) {
		this.openPrice = openPrice;
	}

	public String getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(String lowPrice) {
		this.lowPrice = lowPrice;
	}

	public String getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(String highPrice) {
		this.highPrice = highPrice;
	}

	public String getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(String lastPrice) {
		this.lastPrice = lastPrice;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(String bidPrice) {
		this.bidPrice = bidPrice;
	}

	public String getAskPrice() {
		return askPrice;
	}

	public void setAskPrice(String askPrice) {
		this.askPrice = askPrice;
	}

	public long getAt() {
		return at;
	}

	public void setAt(long at) {
		this.at = at;
	}

	public double getChange24Hrs() {
		double startPriceLong = NumberUtils.parseNumber(lastPrice.trim(), Double.class);
		double openPriceLong = NumberUtils.parseNumber(openPrice.trim(), Double.class);
		setChange24Hrs((100 * (startPriceLong / openPriceLong)) - 100);
		return change24Hrs;
	}

	private void setChange24Hrs(double change24Hrs) {
		this.change24Hrs = change24Hrs;
	}
	
}
