package listener;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import controller.Controller;

@WebListener
public class HandlerMappingListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {

	}

	/**
	 * 미리 생성한 객체를 생성해서 Map에 저장하고 Map에 application 영역에 저장한다
	 */

	/*
	 * 미리 생성할 객체를 생성해서 Map에 저장하고 Map에 application영역에 저장한다.
	 */
	public void contextInitialized(ServletContextEvent e) {
		// context-param정보 가져오기
		ServletContext application = e.getServletContext();
		String fileName = application.getInitParameter("fileName");

		Map<String, Controller> map = new HashMap<String, Controller>();
		Map<String, Class<?>> clzMap = new HashMap<String, Class<?>>();
		// 미리 생성해야하는 객체에 대한 정보를 가지고 있는
		// ~.properties파일을 로딩하기

		// baseName에 확장자는 생략한다.
		ResourceBundle rb = ResourceBundle.getBundle(fileName);
		for (String key : rb.keySet()) {
			String value = rb.getString(key);
			// String 형태인 value를 객체로 만든다.
			try {
				Class<?> cls = Class.forName(value);
				Controller controller = (Controller) Class.forName(value).newInstance();
				map.put(key, controller);
				clzMap.put(key, cls);
				System.out.println(key + " = " + controller);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
		application.setAttribute("map", map);
		application.setAttribute("clzMap", clzMap);
	}

}
