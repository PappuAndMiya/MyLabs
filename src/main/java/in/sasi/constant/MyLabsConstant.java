package in.sasi.constant;

public final class MyLabsConstant {

	//files
	public static final String STARTING_MYLABS_WAV = "starting-mylabs.wav";
	public static final String SYSTEM_PROPERTIES_FILE = "system.properties";
	
	//host
	public static final String ENDPOINT_HOST = "endpoint.host";
	
	//end points
	public static final String ENDPOINT_PING = "endpoint.general.ping";
	public static final String ENDPOINT_SERVER_TIME = "endpoint.general.server.time";
	public static final String ENDPOINT_SYSTEM_STATUS = "endpoint.general.system.status";
	public static final String ENDPOINT_EXCHANGE_INFO = "endpoint.general.exchange.info";
	
	public static final String ENDPOINT_TICKERS = "endpoint.public.tickers";
	public static final String ENDPOINT_TICKER = "endpoint.public.ticker";
	
	//others
	public static final String PREFERRED_TRADE_CURRENCY = "preferred.trade.currency";
	
	private static MyLabsConstant myLabsConstant = new MyLabsConstant();
	
	private MyLabsConstant() {
		
	}
	
	public static MyLabsConstant getInstance() {
		return myLabsConstant;
	}

}
