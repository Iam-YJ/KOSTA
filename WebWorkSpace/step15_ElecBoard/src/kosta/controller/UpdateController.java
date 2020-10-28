package kosta.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.dto.Electronics;
import kosta.model.service.ElectronicsService;

public class UpdateController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("update 요청 ");

		// update.jsp 에서 넘어오는 것들
		String modelNum = request.getParameter("modelNum");
		String modelName = request.getParameter("model_name");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		String password = request.getParameter("password");


		Electronics electronics = new Electronics(modelNum, modelName, Integer.parseInt(price), description, password);

		// update 실행한다
		ElectronicsService.update(electronics);
		ModelAndView mv = new ModelAndView();

		// 성공했으니 read.jsp로 이동한다 -> 모델번호 해당하는 정보 가져와서 이동
		/*
		 * Electronics elec = ElectronicsService.selectByModelnum(modelNum, false);
		 * 
		 * request.setAttribute("elec", elec); mv.setViewName("elecView/read.jsp");
		 */

		mv.setViewName("elec?command=read?&modelNum=" +URLEncoder.encode(modelNum,"UTF-8") + "&flag=1");
		mv.setRedirect(true); //기존에 가지던 request, response 사라지고 새롭게 만들어진것을 들고 감 
		
		
		return mv;

	}

}
