package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController implements Controller {

	/**
	 * 회원관리 관련된 Controller
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

	/**
	 * 회원 가입
	 */
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("UserController의 register이다.");
		return new ModelAndView("index.jsp", true);
	}

	/**
	 * 로그인하기
	 */
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("UserController의 login이다.");
		return new ModelAndView("index.jsp", true);
	}

}
