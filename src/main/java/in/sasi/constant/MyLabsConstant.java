package in.sasi.constant;

public final class MyLabsConstant {

	public static final String STARTING_MYLABS_WAV = "starting-mylabs.wav";
	
	public static final String SYSTEM_PROPERTIES_FILE = "system.properties";
	
	public static final String PREFERRED_TRADE_CURRENCY = "preferred.trade.currency";

	private static MyLabsConstant myLabsConstant = new MyLabsConstant();
	
	private MyLabsConstant() {
		
	}
	
	public static MyLabsConstant getInstance() {
		return myLabsConstant;
	}

}
