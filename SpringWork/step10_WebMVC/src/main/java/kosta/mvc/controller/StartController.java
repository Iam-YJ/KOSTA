package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //�����ϴ� �� <bean
public class StartController {

	@RequestMapping("/index.do") // index.do��� ���� �� �޼ҵ带 �������ּ��� . handlerMapping ���� 
	public ModelAndView aa() {
		System.out.println("index.do�� ��û�Ǿ� aa() ȣ��� ");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("message","Spring web mvc �ű��ϴ� "); //view���� ${message}�� ��밡��
		mv.setViewName("result"); //WEB-INF/views/result.jsp
		
		
		
		return mv;
	}
	
}
