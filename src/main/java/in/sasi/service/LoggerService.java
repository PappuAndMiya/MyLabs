package in.sasi.service;

import org.apache.log4j.Logger;

public interface LoggerService {

	void info(Logger logger, String message);
	
	void error(Logger logger, String message, Throwable throwable);
	
}
