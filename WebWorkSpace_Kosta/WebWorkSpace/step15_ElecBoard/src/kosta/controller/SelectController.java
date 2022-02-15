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
		System.out.println("selectController 요청됨 ");
		String url = "elecView/list.jsp";

		// 서비스 호출 -> dao 호출 -> 그 결과 받아서 이동

		List<Electronics> list = ElectronicsService.selectAll();
		request.setAttribute("list", list);

		ModelAndView mv = new ModelAndView();
		mv.setViewName(url);

		return mv;
	}

}
