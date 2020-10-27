package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("deleteController 입니다");

		// 서비스 호출 - dao 호출
		request.setAttribute("message", "삭제 결과 성공했어요");
		
		//등록이 성공했으니 Redirect 방식으로 select 요청 한다 
		ModelAndView mv = new ModelAndView("index.jsp", true);
		
		return mv;
	}

}
