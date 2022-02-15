package kosta.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.dto.Electronics;
import kosta.model.service.ElectronicsService;

public class SelectController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("selectController ��û�� ");
		String url = "elecView/list.jsp";

		// ���� ȣ�� -> dao ȣ�� -> �� ��� �޾Ƽ� �̵�

		List<Electronics> list = ElectronicsService.selectAll();
		request.setAttribute("list", list);

		ModelAndView mv = new ModelAndView();
		mv.setViewName(url);

		return mv;
	}

}
