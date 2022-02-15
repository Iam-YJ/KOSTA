package kosta.test.vedio;

import org.springframework.stereotype.Service;

import kosta.test.service.Player;

@Service
public class VedioImpl implements Player {
	
	public VedioImpl() {
		
	}

	public void start(int volumn) {
		System.out.println("VedioImpl start(int volumn) 호출");
		
	}

	public String pause() {
		System.out.println("VedioImpl pause() 호출");
		return "VedioImpl 리턴값";
	}

	public void stop() {
		System.out.println("VedioImpl stop() 호출");
		
	}

}
