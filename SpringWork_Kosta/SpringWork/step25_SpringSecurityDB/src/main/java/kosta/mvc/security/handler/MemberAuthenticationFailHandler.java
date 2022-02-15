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
	//������ ���õ� ������ ���� �� �����Ѵ� (AuthenticationException)
	//security.xml���� authentic..��¼��..ref�� ���� 

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) 
			throws IOException, ServletException {
		
		request.setAttribute("errorMessage", exception.getMessage());
		
		request.getRequestDispatcher("/WEB-INF/views/member/loginForm.jsp").forward(request, response);
		//������ ���� filter�� ����ä�� �ٽ� �����ִ� ���
		// filter�� dispatcher servlet���� �� �տ� �ִ�
	}

}


