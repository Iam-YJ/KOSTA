package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController implements Controller {

	/**
	 * ȸ������ ���õ� Controller
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

	/**
	 * ȸ�� ����
	 */
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("UserController�� register�̴�.");
		return new ModelAndView("index.jsp", true);
	}

	/**
	 * �α����ϱ�
	 */
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("UserController�� login�̴�.");
		return new ModelAndView("index.jsp", true);
	}

}
