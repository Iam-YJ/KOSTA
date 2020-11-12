package kosta.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.model.dto.TransferDTO;
import kosta.mvc.model.exception.MyException;
import kosta.mvc.model.service.TransferService;

@Controller
public class TransferController {
    @Autowired
	private TransferService transferService;
    
    @RequestMapping(value = "/")
	public String aa() {
		return "transaction";
	}
    
	@RequestMapping("/transfer")
	public String transfer(TransferDTO transferDTO){
		
		transferService.transfer(transferDTO);
		
		return "result";
	}
	
	@ExceptionHandler(MyException.class)
	public ModelAndView error(MyException ex) {
		return new ModelAndView("error", "errMessage" ,ex.getMessage());
	}
}








