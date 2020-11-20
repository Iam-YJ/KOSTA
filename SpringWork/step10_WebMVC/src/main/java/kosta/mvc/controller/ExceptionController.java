package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.swing.internal.plaf.metal.resources.metal;

@Controller
public class ExceptionController {
	@RequestMapping("/exception.do")
	public ModelAndView aa(String no) {

		int convertNo = Integer.parseInt(no);
		int re = 100 / convertNo;

		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "exceptionCon�� �Դϴ� �����۵��߽��ϴ�");
		mv.setViewName("result");

		return mv;
	}

	/**
	 * ���� Controller���� �߻��ϴ� ���ܸ� ó���� �޼ҵ带 �ۼ�
	 */
	@ExceptionHandler(value = {NumberFormatException.class, ArithmeticException.class})
	public ModelAndView exception(Exception e) {
		// ���ܰ� �߻����� �� �ؾ� �� �� �ۼ�

		System.out.println("exceptionHandler�� ����Ǿ����ϴ� ");

		ModelAndView mv = new ModelAndView();
		mv.addObject("errClass", e.getClass());
		mv.addObject("errMsg", e.getMessage());

		mv.setViewName("error/errorView");
		return mv;
	}

}
