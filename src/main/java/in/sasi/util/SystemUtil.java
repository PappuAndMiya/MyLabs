package in.sasi.util;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import in.sasi.constant.MyLabsConstant;

public final class SystemUtil {

	private static final Logger LOG = Logger.getLogger(SystemUtil.class);
	private static final Properties SYSTEM_CONFIG = new Properties();

	private SystemUtil() {
		
	}
	
	public static String getProperty(String key) {
		if(SYSTEM_CONFIG.isEmpty()) {
			loadSystemProperties();
		}
		return (String) SYSTEM_CONFIG.getOrDefault(key, StringUtils.EMPTY);
	}

	private static void loadSystemProperties() {
		try {
			synchronized (SYSTEM_CONFIG) {
				SYSTEM_CONFIG.load(getClassLoader().getResourceAsStream(MyLabsConstant.SYSTEM_PROPERTIES_FILE));
			}
		} catch (IOException ex) {
			LOG.error("Error while loading system config", ex);
		}
	}
	
	private static ClassLoader getClassLoader() {
		return MyLabsConstant.getInstance().getClass().getClassLoader();
	}

}
