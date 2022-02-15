package kosta.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kosta.test.service.Player;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("kosta/test/advice/applicationContext.xml");
		Player t = context.getBean("tvImpl",Player.class);
		t.start(1);
		t.pause();
		t.stop();
		
		
		Player a = context.getBean("audioImpl",Player.class);
		a.start(1);
		a.pause();
		a.stop();
		
		Player v = context.getBean("vedioImpl",Player.class);
		v.start(1);
		v.pause();
		v.stop();
		

	
	}

}
