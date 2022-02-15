# Servlet 

## Servlet 만들기

* Java 중심 코드로 웹 브라우저에서 동작
* JSP (마크업 중심 + 자바 조금) = Servlet (자바 중심 + 마크업 조금)
  
  
  Test.java
  ```java
  public class Test extends HttpServlet{
      // 필요한 method를 재정의해서 사용함(오버라이딩)
    
        1.init()
        
        2.service() 
        - 사용자 요청 들어오면 요청방식이 get 방식이면 doGet()호출 
        / post 방식이면 doPost() 호출
        
        3.doGet()
        4.doPost()

        5.destroy() 
        - class 종료될 때 호출됨
  }
  ```

    *Servlet 실행 하려면 등록해야함(설정).
  ```java
  1. web.xml 설정
  2. @Annotation 설정 
  ```


## Servlet 동작원리

요청 -> servlet 생성 -> init() -> service() [doGet() / doPost()] -> destroy()


### 예시
```html
LoginForm.html

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> 회원 인증 Page - get 방식</h2>

<form method="get" action="../login">
  ID : <input type="text" name="userId" /><br/>
  PWD : <input type="password" name="userPwd" /><br/>
  NAME : <input type="text" name="userName" /><br/>
 
  <input type="submit" value="로그인" /> 
</form>

<hr>

<h2> 회원 인증 Page - post 방식</h2>

<form method="post" action="../login">
  ID : <input type="text" name="userId" /><br/>
  PWD : <input type="password" name="userPwd" /><br/>
  NAME : <input type="text" name="userName" /><br/>
 
  <input type="submit" value="로그인" /> 
</form>
</body>
</html>
```

``` java
LoginServlet.java
package ex1020.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//등록하기 해야함
public class LoginServlet extends HttpServlet {
	String dbId = "jang";
	String dbPwd = "1234";
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8"); //post방식일 때 한글인코딩 설정 
		
		HttpSession session = req.getSession();
		
		//전송되는 데이터 받기
		String id = req.getParameter("userId");
		String pwd = req.getParameter("userPwd");
		
		PrintWriter out = resp.getWriter();
		
		//인증절차를 하고 일치하면 세션에 정보를 저장하고 LoginOk.jsp으로 이동
		if(dbId.equals(id) && dbPwd.equals(pwd)) {
			
			session.setAttribute("id",id);
			out.println("<h1>로그인 되었습니다.</h1>");
			resp.sendRedirect("session/LoginOK.jsp");
		}else {
		
			out.println("<html>");
			out.println("<head><title></title></head>");
			out.println("<body>");
			out.println("<h1 style='color:red'>회원 정보가 일치하지 않습니다.</h1>");
			out.println("</body>");
			out.println("</html>");
			
			resp.sendRedirect("session/LoginOK.jsp");
		}
		
		
		//틀리면 메세지 출력하고 뒤로가기 한다 
	}

}

```

```html
loginOK.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	//클라이언트쪽의 cache 기능 만료시켜야 한다
    	response.setHeader("Cache-Control", "no-store");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=application.getContextPath() %>/js/jquery-3.5.1.js"></script>

<script>
$(function(){
	$("[type=button]").click(function(){
		if(confirm("정말 로그아웃 할래?")){
			//이동하기
			location.href = "../logout";
			<%-- location.href = "<%=request.getContextPath()%>/logout"; --%>
			
		}
	});
})

</script>

</head>

<body>
<h3>

<% 
if (session.getAttribute("id") == null) {
    //response.sendRedirect("LoginForm.jsp");
    %>
    <script>
    alert("인증하고 오세요");
   location.href = "LoginForm.html";
    </script>
    
    <% 
    
}else{
	%>
	<h3><%=session.getAttribute("id")%>님 로그인중 <br>
	<img src="img/common.jpg"><p>
	
	<button type="button">로그아웃</button>
	</h3>
	<%
}

%>


	</h3>
</body>
</html>
```

```java
logoutServlet.java
package ex1020.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class logoutServlet extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		session.invalidate();
		resp.sendRedirect("session/LoginForm.html");

	}

}

```

```xml
web.xml
<web-app>
  <!-- servlet 등록하기 
  lifeCycle =  new LifeCycleServlet(); 
   *load-on-startup는 서블릿을 생성하는 시점을 설정하는 것으로
    load-on-startup을 설정하면 server가 start될 때 객체를 미리 생성한다 

  
  -->
  <servlet>
  <servlet-name>lifeCycle</servlet-name>
  <servlet-class>ex1020.servlet.LifeCycleServlet</servlet-class>
  <load-on-startup>1</load-on-startup>
  </servlet>
  
  
    <servlet>
  <servlet-name>loginForm</servlet-name>
  <servlet-class>ex1020.servlet.LoginServlet</servlet-class>
  <load-on-startup>2</load-on-startup>
  </servlet>
  
    <servlet>
  <servlet-name>loginOutForm</servlet-name>
  <servlet-class>ex1020.servlet.logoutServlet</servlet-class>
  <load-on-startup>3</load-on-startup>
  </servlet>
  
  
  <!-- 브라우저에서 ~라고 요청했을 때 어떤 서블릿을 실행해야하는지 설정 
  	servlet-name은 servlet 등록 네임과 같아야 함
    실행되면 service 함수 호출 .. 
  -->
  <servlet-mapping>
  <servlet-name>lifeCycle</servlet-name>
  <url-pattern>/life</url-pattern>
  </servlet-mapping>
  
    <servlet-mapping>
  <servlet-name>loginForm</servlet-name>
  <url-pattern>/login</url-pattern>
  </servlet-mapping>
  
     <servlet-mapping>
  <servlet-name>loginOutForm</servlet-name>
  <url-pattern>/logout</url-pattern>
  </servlet-mapping>
</web-app>
```

✔ 참고 ~Servlet.java를 만들면 web.xml에 꼭 등록하기 !

