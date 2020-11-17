package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //생성하는 것 <bean
public class StartController {

	@RequestMapping("/index.do") // index.do라고 오면 이 메소드를 실행해주세요 . handlerMapping 역할 
	public ModelAndView aa() {
		System.out.println("index.do가 요청되어 aa() 호출됨 ");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("message","Spring web mvc 신기하다 "); //view에서 ${message}로 사용가능
		mv.setViewName("result"); //WEB-INF/views/result.jsp
		
		
		
		return mv;
	}
	
}
