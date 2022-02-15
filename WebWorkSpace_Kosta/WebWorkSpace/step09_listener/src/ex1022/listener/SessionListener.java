package ex1022.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {
	
	public SessionListener() {
		System.out.println("SessionListener ������ ȣ��� ");
	}
	
	/**
	 * Session�� ���۵� �� ȣ��
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("sessionListener�� sessionCreated ȣ��� ");
	}

	/**
	 * Session�� ����� �� ȣ�� : session timeout �� �� : session.invalidate() ȣ�� �� �� : ������
	 * â x�� Ŭ���ؼ� ���� ������ ȣ����� ����
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("sessionListener�� sessionDestroyed ȣ��� ");

	}

}
