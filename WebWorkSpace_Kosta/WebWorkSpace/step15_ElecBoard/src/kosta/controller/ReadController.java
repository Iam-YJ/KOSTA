package kosta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.dto.Electronics;
import kosta.model.service.ElectronicsService;

public class ReadController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)throws Exception {
		//모델번호를 받기
		String modelNum = request.getParameter("modelNum");
		String flag = request.getParameter("flag");
		
		boolean state = flag==null? true : false ; 
		//flag가 null 이면 조회수 증가하자 ~ 
		//flag가 null이 아니면(1인지 2인지는 중요 x) 조회수 증가하지 말자 
		
		Electronics eletronics = 
			ElectronicsService.selectByModelnum(modelNum, state);// true면 조회수 증가하자.
		
		request.setAttribute("elec", eletronics);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("elecView/read.jsp");
		return mv;
	}

}
