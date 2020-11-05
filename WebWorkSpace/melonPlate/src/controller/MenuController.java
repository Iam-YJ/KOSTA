package controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.Menu;
import model.service.MelonService;
import model.service.MenuService;
@WebServlet("/menu")
public class MenuController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ModelAndView selectMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 서비스 호출 -> dao 호출해서 그결과 받아서 이동
		List<Menu> list = MenuService.selectMenu();
		request.setAttribute("list", list);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("");

		return mv;
	}
	
	public ModelAndView updateMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 서비스 호출 -> dao 호출해서 그결과 받아서 이동

		String resNo = request.getParameter("resNo");
		int result = MelonService.updateHits(Integer.parseInt(resNo));

		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true);
		mv.setViewName("");

		return mv;
	}

}
