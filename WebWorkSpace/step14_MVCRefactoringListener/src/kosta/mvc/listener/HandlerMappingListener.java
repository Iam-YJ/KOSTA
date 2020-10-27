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
	 * �̸� ������ ��ü�� �����ؼ� Map�� �����ϰ� Map�� application ������ �����Ѵ�
	 */
	public void contextInitialized(ServletContextEvent e) {
		// context-param ���� ��������
		ServletContext application = e.getServletContext();
		String fileName = application.getInitParameter("fileName");
		Map<String,Controller> map = new HashMap<String, Controller>();

		// �̸� �����ؾ��ϴ� ��ü�� ���� ������ ������ �ִ�
		// ~.properties ������ �ε��ؾ��Ѵ�

		// baseName�� Ȯ���ڴ� �����Ѵ� (.properties ����)
		ResourceBundle rb = ResourceBundle.getBundle(fileName);

		for (String key : rb.keySet()) {
			String value = rb.getString(key);
			System.out.println(key + " : "+value);

			// String ������ Value�� ��ü�� �������Ѵ�
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
