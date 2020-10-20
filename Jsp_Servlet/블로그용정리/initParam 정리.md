
# init-param 전달하기 

## Servlet 당 전달 되는 param
 	- 해당 servlet에서만 사용 가능함
    
```java
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
            // init-param정보 받기
            id = super.getInitParameter("id");
            addr = super.getInitParameter("addr");

            // context-param정보 가져오기
            ServletContext application = super.getServletContext();
            fileName = application.getInitParameter("fileName");
            driverName = application.getInitParameter("driverName");

        }

        @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            System.out.println("service....");
            System.out.println(id + "  , " + addr);
            System.out.println(fileName + "  , " + driverName);

        }
    }
    
 ```

```xml
<web-app>
 <!-- 모든 영역(servlet or jsp)에서 공유해서 사용할 init-param설정 -->
   <context-param>
     <param-name>fileName</param-name>
     <param-value>c://Edu</param-value>
   </context-param>
   <context-param>
     <param-name>driverName</param-name>
     <param-value>jdbc.odbc.oracle.JdbcDriver</param-value>
   </context-param>
   
  
  <servlet>
    <servlet-name>InitParamServlet</servlet-name>
    <servlet-class>ex1020.servlet.InitParamServlet</servlet-class>
    <init-param>
      <param-name>id</param-name>
      <param-value>jang</param-value>
    </init-param>
    <init-param>
      <param-name>addr</param-name>
      <param-value>서울</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
  </servlet>
  
  <servlet-mapping>
    <servlet-name>InitParamServlet</servlet-name>
    <url-pattern>/init</url-pattern>
  </servlet-mapping>
  
</web-app>

```
* @Annotation 방식을 사용하지 않으면 web.xml에서 설정을 해줘야한다



## application 영역에 전달되는 param
	- 다른 servlet에서도 사용 가능함 

```java
package ex1020.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 * 
 * web.xml문서의 <servlet> </servlet> <servlet-mapping></servlet-mapping>
 */
@WebServlet(urlPatterns = "/test", initParams = @WebInitParam(name = "message", value = "집에가고파"))
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String message, id;
	String fileName, driverName;

	public void init(ServletConfig config) throws ServletException {
		message = config.getInitParameter("message");
		id = config.getInitParameter("id");

		// context-param정보 가져오기
		ServletContext application = config.getServletContext();
		fileName = application.getInitParameter("fileName");
		driverName = application.getInitParameter("driverName");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("message : " + message);
		out.println("id : " + id);
		out.println("fileName : " + fileName);
		out.println("driverName : " + driverName);
	}

}
```
* web.xml 변경해주지 않아도 된다.
* 다른 파일에서도 값 사용 가능하다.
  
```html
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>
		fileName :<%=application.getInitParameter("fileName")%>
		<br> driverName :<%=application.getInitParameter("driverName")%>
		<br>
	</h3>
</body>
</html>
```