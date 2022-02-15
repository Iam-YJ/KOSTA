package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
/**
 * 게시판에 관련된 Controller
 */
import javax.servlet.http.HttpServletResponse;

public class BoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

		return null;
	}

	/**
	 * 전체보기
	 */
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardContorller의 list 호출되었습니다");
		return new ModelAndView("index.jsp", true);
	}

	/**
	 * 상세보기
	 */

	public ModelAndView read(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardContorller의 read 호출되었습니다");
		return new ModelAndView("index.jsp", true);
	}

}
