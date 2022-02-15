package ex1022.filter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class CounterFilter
 */
@WebFilter(urlPatterns = { "/*" }, initParams = { @WebInitParam(name = "fileName", value = "clickcount.properties") })
public class CounterFilter implements Filter {
	String fileName;
	File file;
	Properties pro = new Properties();

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		fileName = filterConfig.getInitParameter("fileName");
		
		// 실제 프로젝트의 root 경로를 가져오기
		ServletContext application = filterConfig.getServletContext();
		String path = application.getRealPath("/");
		file = new File(path + "/" + fileName);
		//System.out.println("path = " + path);
		//C:\Edu\WebWorkSpace_Kosta\WebWorkSpace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\step08_Filter\
		
		
		
		try {
			if (!file.exists()) {

				file.createNewFile();
			}
			pro.load(new FileInputStream(file));
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 *  병렬처리 프로세스를 분산시켜 좀 더 빠르게 작업 할 수 있도록 하는 것 
	 *  jdk 1.5 추가
	 *  Executor : 기본스레드 제공
	 *  ExecutorService : Executor 인터페이스의 확장 interface로 스레드의 라이프사이클을 전반적으로 관리하는 메소드 제공
	 *  					(생성 ~ 소멸되기까지 관련 함수 제공)
	 */
	ExecutorService service = Executors.newSingleThreadExecutor();
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//사전처리
		//현재 요청된 url주소를 얻기
		service.execute(new Runnable() {
			public void run() {
				
				  HttpServletRequest req = (HttpServletRequest)request; String url =
				  req.getRequestURL().toString(); String value = pro.getProperty(url);
				  
				  if(value == null) { pro.setProperty(url,"1"); }else { int count =
				  Integer.parseInt(value)+1; pro.setProperty(url, count+""); }
				  
			}
		});
		  chain.doFilter(request, response);
			 //사후 처리 ~~
		  
//		  if(session.getAttribute("id")==null) {
//			  throw new RuntimeException()
//			  return ;
//		  }
		  //에러 발생 후에 retrun 으로 멈춰야 한다 
		  //아래 있는 것 실행하지 못하게 
		
	}
	
	@Override
	public void destroy() {
		//최종 Properties 객체 있는 데이터를 파일에 저장한다 
		try {
			pro.store(new FileWriter(file), "");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
