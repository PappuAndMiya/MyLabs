package in.sasi.service.impl;

import org.apache.log4j.Logger;

import in.sasi.service.LoggerService;

public class LoggerServiceImpl implements LoggerService {

	@Override
	public void info(Logger logger, String message) {
		logger.info(message);
	}

	@Override
	public void error(Logger logger, String message, Throwable throwable) {
		logger.error(message, throwable);
	}

}
