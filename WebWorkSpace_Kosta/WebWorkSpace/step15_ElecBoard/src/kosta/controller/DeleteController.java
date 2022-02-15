package kosta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.service.ElectronicsService;

public class DeleteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String modelNum = request.getParameter("modelNum");
		String password = request.getParameter("password");
		String path = request.getServletContext().getRealPath("/save");

		ElectronicsService.delete(modelNum, password, path);
		ModelAndView mv = new ModelAndView("elec",true);
		//그냥 새로 가져오는 redirect 할꺼니까 true
		
		return mv;
	}

}
