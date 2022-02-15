package ex1022.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Listener�� ����Ϸ��� ���� �ʿ���(��� = ����)
 * 1) web.xml
 * 		<listener> Ŭ���� �̸� </listener>
 *  listener�� mapping�� ����. �ڵ����� ����Ǳ� ������ (~~�� �� ����������� mapping �ʿ����� ����)
 *  
 * 2) @Annotaion
 * 		-@webListener
 *
 */

//������ start �Ǹ� �ڵ����� ȣ��� 

public class AppListener implements ServletContextListener {

	/**
	 * ������ ����� �� ȣ��ȴ� (�Ǵ� reload �� �� ȣ���)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("AppListener�� contextDestroyed call");
	}

	/**
	 * ������ start�� ��  �ڵ� ȣ��ȴ� 
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("AppListener�� contextInitialized call");
		
		//�� ���� �����ڵ�� ������� �����ϱ� ���� �̸� �����͸� �����س��´�
		
		Map<String, String> nationMap = new HashMap<String, String>();
		nationMap.put("kr","���ѹα�");
		nationMap.put("jp","�Ϻ�");
		nationMap.put("fr","������");
		nationMap.put("cn","�߱�");
		nationMap.put("us","�̱�");
		
		//ServletContext ������ �����Ѵ�
		ServletContext application = sce.getServletContext();
		application.setAttribute("nationMap", nationMap); //jsp ���� ${applicationScope.nationMap}
		
		
		
	}
	
	

}
