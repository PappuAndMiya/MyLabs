package in.sasi.service.impl;

import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.apache.log4j.Logger;

import in.sasi.service.AudioService;

public class AudioServiceImpl implements AudioService {

	private static final Logger LOG = Logger.getLogger(AudioServiceImpl.class);
	
	@Override
	public void play(String fileName) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(getClass().getClassLoader().getResource(fileName)));
			clip.start();
		} catch (IOException | LineUnavailableException | UnsupportedAudioFileException ex) {
			LOG.error("Error while playing audio", ex);
		}
	}

}
