package kosta.test.service;

import org.springframework.stereotype.Service;


public interface Player {
	
	void start(int volumn);
	String pause();
	void stop();

}
