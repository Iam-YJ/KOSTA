package kosta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.dto.Electronics;
import kosta.model.service.ElectronicsService;

public class UpdateFormController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//수정을 하기 위해 폼을 띄우기 - 모델 번호에 해당하는 정보 가져오기 (조회수 증가안함)
		
		String modelNum = request.getParameter("modelNum");
		
		Electronics elec = ElectronicsService.selectByModelnum(modelNum, false); //조회수 증가 안함
		
		request.setAttribute("elec", elec);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("elecView/update.jsp");
		
		
		
		
		return mv;
	}

}
