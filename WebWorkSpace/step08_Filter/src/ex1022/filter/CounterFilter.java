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
		
		// ���� ������Ʈ�� root ��θ� ��������
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
	 *  ����ó�� ���μ����� �л���� �� �� ������ �۾� �� �� �ֵ��� �ϴ� �� 
	 *  jdk 1.5 �߰�
	 *  Executor : �⺻������ ����
	 *  ExecutorService : Executor �������̽��� Ȯ�� interface�� �������� ����������Ŭ�� ���������� �����ϴ� �޼ҵ� ����
	 *  					(���� ~ �Ҹ�Ǳ���� ���� �Լ� ����)
	 */
	ExecutorService service = Executors.newSingleThreadExecutor();
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//����ó��
		//���� ��û�� url�ּҸ� ���
		service.execute(new Runnable() {
			public void run() {
				
				  HttpServletRequest req = (HttpServletRequest)request; String url =
				  req.getRequestURL().toString(); String value = pro.getProperty(url);
				  
				  if(value == null) { pro.setProperty(url,"1"); }else { int count =
				  Integer.parseInt(value)+1; pro.setProperty(url, count+""); }
				  
			}
		});
		  chain.doFilter(request, response);
			 //���� ó�� ~~
		  
//		  if(session.getAttribute("id")==null) {
//			  throw new RuntimeException()
//			  return ;
//		  }
		  //���� �߻� �Ŀ� retrun ���� ����� �Ѵ� 
		  //�Ʒ� �ִ� �� �������� ���ϰ� 
		
	}
	
	@Override
	public void destroy() {
		//���� Properties ��ü �ִ� �����͸� ���Ͽ� �����Ѵ� 
		try {
			pro.store(new FileWriter(file), "");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
