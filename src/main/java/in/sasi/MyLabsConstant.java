package in.sasi;

public final class MyLabsConstant {

	public static final String STARTING_MYLABS_WAV = "starting-mylabs.wav";
	
	public static final String SYSTEM_PROPERTIES = "system.properties";

	private static MyLabsConstant myLabsConstant = new MyLabsConstant();
	
	private MyLabsConstant() {
		
	}
	
	public static MyLabsConstant getInstance() {
		return myLabsConstant;
	}

}
