package ex1022.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Listener를 사용하려면 생성 필요함(등록 = 설정)
 * 1) web.xml
 * 		<listener> 클래스 이름 </listener>
 *  listener는 mapping이 없다. 자동으로 실행되기 때문에 (~~일 때 실행시켜줘인 mapping 필요하지 않음)
 *  
 * 2) @Annotaion
 * 		-@webListener
 *
 */

//서버만 start 되면 자동으로 호출됨 

public class AppListener implements ServletContextListener {

	/**
	 * 서버가 종료될 때 호출된다 (또는 reload 될 때 호출됨)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("AppListener의 contextDestroyed call");
	}

	/**
	 * 서버가 start할 때  자동 호출된다 
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("AppListener의 contextInitialized call");
		
		//각 나라별 국가코드와 나라명을 관리하기 위해 미리 데이터를 저장해놓는다
		
		Map<String, String> nationMap = new HashMap<String, String>();
		nationMap.put("kr","대한민국");
		nationMap.put("jp","일본");
		nationMap.put("fr","프랑스");
		nationMap.put("cn","중국");
		nationMap.put("us","미국");
		
		//ServletContext 영역에 저장한다
		ServletContext application = sce.getServletContext();
		application.setAttribute("nationMap", nationMap); //jsp 영역 ${applicationScope.nationMap}
		
		
		
	}
	
	

}
