package ex1022.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(urlPatterns= {"/*"}, 
initParams= {@WebInitParam(name = "encoding", value = "UTF-8")})
public class EncodingFilter implements Filter {
	String encoding ;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		//����ó��
		request.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response); //��û�� ������Ʈ�� ȣ��ȴ�
		//����ó��
	}

}