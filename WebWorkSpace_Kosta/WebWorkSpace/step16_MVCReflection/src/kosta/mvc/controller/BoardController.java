package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
/**
 * �Խ��ǿ� ���õ� Controller
 */
import javax.servlet.http.HttpServletResponse;

public class BoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

		return null;
	}

	/**
	 * ��ü����
	 */
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardContorller�� list ȣ��Ǿ����ϴ�");
		return new ModelAndView("index.jsp", true);
	}

	/**
	 * �󼼺���
	 */

	public ModelAndView read(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardContorller�� read ȣ��Ǿ����ϴ�");
		return new ModelAndView("index.jsp", true);
	}

}
