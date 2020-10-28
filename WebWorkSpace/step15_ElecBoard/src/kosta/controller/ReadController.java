package kosta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.dto.Electronics;
import kosta.model.service.ElectronicsService;

public class ReadController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)throws Exception {
		//�𵨹�ȣ�� �ޱ�
		String modelNum = request.getParameter("modelNum");
		String flag = request.getParameter("flag");
		
		boolean state = flag==null? true : false ; 
		//flag�� null �̸� ��ȸ�� �������� ~ 
		//flag�� null�� �ƴϸ�(1���� 2������ �߿� x) ��ȸ�� �������� ���� 
		
		Electronics eletronics = 
			ElectronicsService.selectByModelnum(modelNum, state);// true�� ��ȸ�� ��������.
		
		request.setAttribute("elec", eletronics);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("elecView/read.jsp");
		return mv;
	}

}
