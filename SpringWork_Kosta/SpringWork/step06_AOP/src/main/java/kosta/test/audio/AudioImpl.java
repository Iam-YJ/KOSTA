package kosta.test.audio;

import kosta.test.service.Player;

public class AudioImpl implements Player {

	public AudioImpl() {
	}

	public void start(int volumn) {
		System.out.println("AudioImpl start(int volumn) 호출");

	}

	public String pause() {
		System.out.println("AudioImpl pause() 호출");
		return "AudioImpl 리턴값";
	}

	public void stop() {
		System.out.println("AudioImpl stop() 호출");

	}

}
