package in.sasi.context;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.apache.log4j.Logger;

import in.sasi.MyLabsConstant;

public class MyLabsServletContextListener implements ServletContextListener {

	private static final Logger LOG = Logger.getLogger(MyLabsServletContextListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		LOG.info("Destroying Context: "+event.getServletContext().getServletContextName());
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		LOG.info("Initializing context: "+event.getServletContext().getServletContextName());
		playSound(MyLabsConstant.STARTING_MYLABS_WAV);
	}
	
	private void playSound(String fileName) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(getClass().getClassLoader().getResource(fileName)));
			clip.start();
		} catch (Exception ex) {
			LOG.error("Error while playing audio", ex);
		}
	}

}
