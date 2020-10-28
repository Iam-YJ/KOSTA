package kosta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.dto.Electronics;
import kosta.model.service.ElectronicsService;

public class UpdateFormController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//������ �ϱ� ���� ���� ���� - �� ��ȣ�� �ش��ϴ� ���� �������� (��ȸ�� ��������)
		
		String modelNum = request.getParameter("modelNum");
		
		Electronics elec = ElectronicsService.selectByModelnum(modelNum, false); //��ȸ�� ���� ����
		
		request.setAttribute("elec", elec);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("elecView/update.jsp");
		
		
		
		
		return mv;
	}

}
