package ex1020.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamServlet extends HttpServlet {
	String id, addr;
	String fileName, driverName;
     @Override
    public void init() throws ServletException {
    	 System.out.println("init......");
    	//init-param정보 받기
    	id = super.getInitParameter("id");
    	addr = super.getInitParameter("addr");
    	
    	//context-param정보 가져오기
    	ServletContext application = super.getServletContext();
    	fileName=application.getInitParameter("fileName");
    	driverName=application.getInitParameter("driverName");
    	
    }
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service....");
		System.out.println(id +"  , " + addr);
		System.out.println(fileName +"  , " + driverName);
		
	}
}




