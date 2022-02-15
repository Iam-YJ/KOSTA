package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.Menu;
import model.service.MenuService;

public class MenuController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 맛집 등록 메소드 호출
	 */
	public ModelAndView insertMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MenuController의 insertMenu 호출되었습니다");

		String resMenu = request.getParameter("resMenu");
		String resPrice = request.getParameter("resPrice");

		Menu menu = new Menu(resMenu, resPrice);

		MenuService.insertMenu(menu);

		ModelAndView mv = new ModelAndView("html/admin_section/add-listing-with-menu-list.jsp", true);

		return mv;

	}

}
