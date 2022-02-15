package ex1022.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SimpleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       System.out.println("SimpleFilter의 init() 호출됨...");
       //init-param정보 받기
      String fileName =  filterConfig.getInitParameter("fileName");
      System.out.println("fileName = "+fileName);
    }
    
    @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("SimpleFilter의 사전 처리입니다....");
		chain.doFilter(request, response);
		System.out.println("SimpleFilter의 사후 처리입니다....");

	}
    
    @Override //renode 되거나 tomcat이 종료될 때 볼 수 있음
    public void destroy() {
    	System.out.println("SimpleFilter의 destory() 호출됨....");
    }
    
	

}
