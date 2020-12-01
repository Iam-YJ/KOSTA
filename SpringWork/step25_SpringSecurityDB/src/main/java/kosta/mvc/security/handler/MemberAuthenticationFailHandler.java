package kosta.mvc.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Service;

@Service // id="memberAuthenticationFailHandler"
public class MemberAuthenticationFailHandler implements AuthenticationFailureHandler {  
	//인증에 관련된 오류가 났을 때 진입한다 (AuthenticationException)
	//security.xml에서 authentic..어쩌구..ref로 잡음 

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) 
			throws IOException, ServletException {
		
		request.setAttribute("errorMessage", exception.getMessage());
		
		request.getRequestDispatcher("/WEB-INF/views/member/loginForm.jsp").forward(request, response);
		//인증한 것을 filter가 가로채서 다시 보내주는 방식
		// filter는 dispatcher servlet보다 더 앞에 있다
	}

}


