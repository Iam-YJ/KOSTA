
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

@WebFilter(	urlPatterns = {
						"/*"
					},
			initParams = {
						@WebInitParam(name = "LogFile", value = "log.txt")
					}
)
public class LogFilter implements Filter {

	private String logPath;
	private String logFileName;
	private File logFile;
    PrintWriter pw;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ServletContext sc = filterConfig.getServletContext();
		logPath = sc.getRealPath("/");
		logFileName = filterConfig.getInitParameter("LogFile");
		System.out.println("logFile = \"" + logPath + logFileName + "\"");
		logFile = new File(logPath + logFileName);
		try {
			if (!logFile.exists()) {
				logFile.createNewFile();
				System.out.println(logFileName + " has been created");
			}
			pw = new PrintWriter(new BufferedWriter(new FileWriter(logFile, true)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

	    PrintLog("Access from IP: " + req.getRemoteAddr() + ":" + req.getRemotePort() + " >> " + req.getServerName() + ":" + req.getServerPort());

	    HttpServletRequest hsr = (HttpServletRequest) req;
		PrintLog(hsr.getRequestURL().toString());
		PrintLog("User-Agent: " + hsr.getHeader("User-Agent"));
		
	    long timeBefore = System.currentTimeMillis();
		chain.doFilter(req, resp);
		long timeAfter = System.currentTimeMillis();

		PrintLog("Filter took in: " + (timeAfter - timeBefore) + " ms");
		PrintLog(new Date().toLocaleString() + "\n");
	}

	@Override
	public void destroy() {
		if (pw != null) {
			pw.flush();
			pw.close();
		}
	}

	public void PrintLog(String msg) throws IOException {
	    System.out.println(msg);
	    pw.println(msg);
		pw.flush(); // Flush every time to testing
	}
}
