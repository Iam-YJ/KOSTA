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
		mv.addObject("message", "exceptionCon안 입니당 정상작동했습니당");
		mv.setViewName("result");

		return mv;
	}

	/**
	 * 현재 Controller에서 발생하는 예외를 처리할 메소드를 작성
	 */
	@ExceptionHandler(value = {NumberFormatException.class, ArithmeticException.class})
	public ModelAndView exception(Exception e) {
		// 예외가 발생했을 때 해야 할 일 작성

		System.out.println("exceptionHandler가 실행되었습니당 ");

		ModelAndView mv = new ModelAndView();
		mv.addObject("errClass", e.getClass());
		mv.addObject("errMsg", e.getMessage());

		mv.setViewName("error/errorView");
		return mv;
	}

}
