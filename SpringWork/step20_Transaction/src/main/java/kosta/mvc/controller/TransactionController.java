package kosta.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.model.dto.TransferDTO;
import kosta.mvc.service.TransactionService;

@Controller
public class TransactionController {

	@Autowired
	private TransactionService service;

	@RequestMapping("/")
	public String index() {
		return "transaction";
	}

	@RequestMapping("/transfer")
	public String transfer(TransferDTO dto) {
		service.transfer(dto);
		return "result";
	}

	/**
	 * 예외처리
	 */
	@ExceptionHandler(value = RuntimeException.class)
	public ModelAndView error(RuntimeException e) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error");
		mv.addObject("errMessage", e.getMessage());
		return mv;
	}

}
