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
 * Board 영역의 등록, 전체검색, 상세보기, 수정, 삭제 등의 페이지를 실행하기 전에 
 * 세션 유무체크를 통해 세션이 있는 경우에만 페이지를 실행하고
 *  없으면 로그인 "인증하고 오세요" 메세지 출력
 *
 */
@Service
@Aspect //JoinPoint와 기능(?)을 연결
// + servlet-context.xml에 <aop:aspectj-autoproxy/>(세션유무체크 aop 설정  Annotation 방법) 추가 필요

public class SessionCheckAdvice {
	
	@Before("execution(public * kosta.web.mvc.board.controller.Board*.*(..))")
	public void before(JoinPoint point) { //해당 기능을 담당하는 컨트롤러에 각각의 메소드 같은 위치에 HttpSession session를 생성한다
		/*
		 * Object params[] = point.getArgs(); HttpSession session = (HttpSession)
		 * params[0]; //params의 [0]에 HttpSession session이 있기 때문에 이것만 필요하다
		 * 
		 * //세션 유무 체크를 한다 if(session == null || session.getAttribute("loginUser") ==
		 * null) { throw new RuntimeException("로그인 후 이용해주세요"); }
		 */
		
		
		/////////////////////////////////////////////////////////////////
		
		//controller에서 HttpSession 매개변수 전달 없이 사용하는 방법
		RequestAttributes requestAttrs = RequestContextHolder.getRequestAttributes(); //holder에 저장되어있는 정보를 꺼내옴
		ServletRequestAttributes servletRequestAttrs = (ServletRequestAttributes)requestAttrs;
		HttpServletRequest request = servletRequestAttrs.getRequest();
		
		HttpSession session = request.getSession();
		
		 if(session == null || session.getAttribute("loginUser") ==null) { 
			 throw new RuntimeException("로그인 후 이용해주세요");
		 }
		
	}

}
