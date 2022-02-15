package ex1022.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {
	
	public SessionListener() {
		System.out.println("SessionListener 생성자 호출됨 ");
	}
	
	/**
	 * Session이 시작될 때 호출
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("sessionListener의 sessionCreated 호출됨 ");
	}

	/**
	 * Session이 종료될 때 호출 : session timeout 될 때 : session.invalidate() 호출 될 때 : 브라우져
	 * 창 x를 클릭해서 닫을 때에는 호출되지 않음
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("sessionListener의 sessionDestroyed 호출됨 ");

	}

}
