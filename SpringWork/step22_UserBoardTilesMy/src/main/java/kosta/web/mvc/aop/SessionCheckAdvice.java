package kosta.web.mvc.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Board ������ ���, ��ü�˻�, �󼼺���, ����, ���� ���� �������� �����ϱ� ���� 
 * ���� ����üũ�� ���� ������ �ִ� ��쿡�� �������� �����ϰ�
 *  ������ �α��� "�����ϰ� ������" �޼��� ���
 *
 */
@Service
@Aspect //JoinPoint�� ���(?)�� ����
// + servlet-context.xml�� <aop:aspectj-autoproxy/>(��������üũ aop ����  Annotation ���) �߰� �ʿ�

public class SessionCheckAdvice {
	
	@Before("execution(public * kosta.web.mvc.board.controller.Board*.*(..))")
	public void before(JoinPoint point) { //�ش� ����� ����ϴ� ��Ʈ�ѷ��� ������ �޼ҵ� ���� ��ġ�� HttpSession session�� �����Ѵ�
		/*
		 * Object params[] = point.getArgs(); HttpSession session = (HttpSession)
		 * params[0]; //params�� [0]�� HttpSession session�� �ֱ� ������ �̰͸� �ʿ��ϴ�
		 * 
		 * //���� ���� üũ�� �Ѵ� if(session == null || session.getAttribute("loginUser") ==
		 * null) { throw new RuntimeException("�α��� �� �̿����ּ���"); }
		 */
		
		
		/////////////////////////////////////////////////////////////////
		
		//controller���� HttpSession �Ű����� ���� ���� ����ϴ� ���
		RequestAttributes requestAttrs = RequestContextHolder.getRequestAttributes(); //holder�� ����Ǿ��ִ� ������ ������
		ServletRequestAttributes servletRequestAttrs = (ServletRequestAttributes)requestAttrs;
		HttpServletRequest request = servletRequestAttrs.getRequest();
		
		HttpSession session = request.getSession();
		
		 if(session == null || session.getAttribute("loginUser") ==null) { 
			 throw new RuntimeException("�α��� �� �̿����ּ���");
		 }
		
	}

}
