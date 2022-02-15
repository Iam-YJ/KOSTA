
package ex1022.filter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//1022 °úÁ¦´ç

@WebFilter("/*")
public class LogFilter implements Filter {
	Log log;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log = LogFactory.getLog(getClass());
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		PrintLog("Access from IP: " + req.getRemoteAddr() + ":" + req.getRemotePort() + " >> " + req.getServerName()
				+ ":" + req.getServerPort());

		HttpServletRequest hsr = (HttpServletRequest) req;
		PrintLog(hsr.getRequestURL().toString());
		PrintLog("User-Agent: " + hsr.getHeader("User-Agent"));

		long timeBefore = System.currentTimeMillis();
		chain.doFilter(req, resp);
		long timeAfter = System.currentTimeMillis();

		PrintLog("Filter took in: " + (timeAfter - timeBefore) + " ms");
	}

	@Override
	public void destroy() {

	}

	public void PrintLog(String msg) throws IOException {
		log.info(msg);
	}
}
