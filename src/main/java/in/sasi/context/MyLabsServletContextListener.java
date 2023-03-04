package in.sasi.context;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class MyLabsServletContextListener implements ServletContextListener {

	private static final Logger LOG = Logger.getLogger(MyLabsServletContextListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		LOG.info("Destroying Context: "+event.getServletContext().getServletContextName());
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		LOG.info("Initializing context: "+event.getServletContext().getServletContextName());
	}

}
