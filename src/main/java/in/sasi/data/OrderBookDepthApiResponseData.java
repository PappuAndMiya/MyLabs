package in.sasi.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class OrderBookDepthApiResponseData {

	private long timestamp;
	private List<List<String>> asks = new ArrayList<List<String>>(); //buy
	private List<List<String>> bids = new ArrayList<List<String>>(); //sell

	private static final int PRICE_POISITION = 0;
	private static final int VOLUME_POISITION = 1;

	private Double buyTotalVolume = null;
	private Double buyMaxPrice = null;
	private Double sellTotalVolume = null;
	private Double sellMinPrice = null;

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public List<List<String>> getAsks() {
		return asks;
	}

	public void setAsks(List<List<String>> asks) {
		this.asks = asks;
	}

	public List<List<String>> getBids() {
		return bids;
	}

	public void setBids(List<List<String>> bids) {
		this.bids = bids;
	}

	public Double getBuyTotalVolume() {
		if (null == buyTotalVolume && CollectionUtils.isNotEmpty(asks)) {
			Double buyTotalVolumeInner = 0D;
			for (List<String> ask : asks) {
				buyTotalVolumeInner = buyTotalVolumeInner + NumberUtils.toDouble(ask.get(VOLUME_POISITION));
			}
			buyTotalVolume = buyTotalVolumeInner;
		}
		return buyTotalVolume;
	}

	public Double getBuyMaxPrice() {
		if (null == buyMaxPrice && CollectionUtils.isNotEmpty(asks)) {
			buyMaxPrice = NumberUtils.toDouble(asks.get(0).get(PRICE_POISITION));
		}
		return buyMaxPrice;
	}

	public Double getSellTotalVolume() {
		if (null == sellTotalVolume && CollectionUtils.isNotEmpty(bids)) {
			Double sellTotalVolumeInner = 0D;
			for (List<String> ask : bids) {
				sellTotalVolumeInner = sellTotalVolumeInner + NumberUtils.toDouble(ask.get(VOLUME_POISITION));
			}
			sellTotalVolume = sellTotalVolumeInner;
		}
		return sellTotalVolume;
	}

	public Double getSellMinPrice() {
		if (null == sellMinPrice && CollectionUtils.isNotEmpty(bids)) {
			sellMinPrice = NumberUtils.toDouble(bids.get(0).get(PRICE_POISITION));
		}
		return sellMinPrice;
	}
	
}
