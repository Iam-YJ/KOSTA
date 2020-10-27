package kosta.mvc.listener;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import kosta.mvc.controller.Controller;

@WebListener
public class HandlerMappingListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {

	}

	/**
	 * 미리 생성한 객체를 생성해서 Map에 저장하고 Map에 application 영역에 저장한다
	 */
	public void contextInitialized(ServletContextEvent e) {
		// context-param 정보 가져오기
		ServletContext application = e.getServletContext();
		String fileName = application.getInitParameter("fileName");
		Map<String,Controller> map = new HashMap<String, Controller>();

		// 미리 생성해야하는 객체에 대한 정보를 가지고 있는
		// ~.properties 파일을 로딩해야한다

		// baseName에 확장자는 생략한다 (.properties 생략)
		ResourceBundle rb = ResourceBundle.getBundle(fileName);

		for (String key : rb.keySet()) {
			String value = rb.getString(key);
			System.out.println(key + " : "+value);

			// String 형태인 Value를 객체로 만들어야한다
			try {
				Controller controller = (Controller) Class.forName(value).newInstance();
				//System.out.println(key + " : "+controller);
				map.put(key, controller);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		application.setAttribute("map", map);
	}

}
