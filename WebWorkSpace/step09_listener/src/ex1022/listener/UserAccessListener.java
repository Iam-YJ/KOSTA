package ex1022.listener;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class UserAccessListener
 *
 */
@WebListener
public class UserAccessListener implements HttpSessionListener, ServletContextListener {
	ServletContext application;
	
	/**
	 * ������ ����� ��
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
	
	/**
	 * ������ start �� ��
	 */
	public void contextInitialized(ServletContextEvent e) {
		application = e.getServletContext();
		application.setAttribute("count", new AtomicInteger());
		
	}
	
	/**
	 * ������ ���۵� ��
	 */
	public void sessionCreated(HttpSessionEvent se) {
		AtomicInteger at = (AtomicInteger) application.getAttribute("count");
		int count = at.incrementAndGet();
		System.out.println("���� �� ��(���� ������ ��)" + count);
	}
	
	/**
	 * ������ ����� ��
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		AtomicInteger at = (AtomicInteger) application.getAttribute("count");
		int count = at.decrementAndGet();
		System.out.println("���� �� ��(���� ������ ��) "+count);
	}

}
