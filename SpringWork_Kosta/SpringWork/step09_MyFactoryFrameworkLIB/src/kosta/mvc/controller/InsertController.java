package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class InsertController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("InsertController ȣ���");
		// ���(���� -> dao)
		// request.setAttribute("message", "���� insertCon �̴�");

		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "���� insertCon �̴� "); // ${requestScope.message}
														//request.setAttribute()...�� ���� ��� 
		mv.setViewName("insertResult"); // prefix + �̸� + suffix ==> /insertResult.jsp
										// dispatcher-servlet.xml���� ������

		return mv;
	}

}
