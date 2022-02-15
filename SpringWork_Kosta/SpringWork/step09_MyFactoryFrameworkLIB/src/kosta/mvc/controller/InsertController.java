package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class InsertController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("InsertController 호출됨");
		// 기능(서비스 -> dao)
		// request.setAttribute("message", "나는 insertCon 이다");

		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "나는 insertCon 이다 "); // ${requestScope.message}
														//request.setAttribute()...와 같은 기능 
		mv.setViewName("insertResult"); // prefix + 이름 + suffix ==> /insertResult.jsp
										// dispatcher-servlet.xml에서 설정함

		return mv;
	}

}
