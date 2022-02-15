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
	 * 서버가 종료될 때
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
	
	/**
	 * 서버가 start 될 때
	 */
	public void contextInitialized(ServletContextEvent e) {
		application = e.getServletContext();
		application.setAttribute("count", new AtomicInteger());
		
	}
	
	/**
	 * 세션이 시작될 때
	 */
	public void sessionCreated(HttpSessionEvent se) {
		AtomicInteger at = (AtomicInteger) application.getAttribute("count");
		int count = at.incrementAndGet();
		System.out.println("증가 후 값(현재 접속자 수)" + count);
	}
	
	/**
	 * 세션이 종료될 때
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		AtomicInteger at = (AtomicInteger) application.getAttribute("count");
		int count = at.decrementAndGet();
		System.out.println("감소 후 값(현재 접속자 수) "+count);
	}

}
