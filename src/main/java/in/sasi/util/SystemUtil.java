package in.sasi.util;

import java.util.HashMap;
import java.util.Map;

public final class SystemUtil {

	private static final Map<String, String> SYSTEM_CONFIG = new HashMap<String, String>();

	static {
		SYSTEM_CONFIG.put("key", "value");
	}
	
	public static String getProperty(String key) {
		return SYSTEM_CONFIG.get(key);
	}

}
