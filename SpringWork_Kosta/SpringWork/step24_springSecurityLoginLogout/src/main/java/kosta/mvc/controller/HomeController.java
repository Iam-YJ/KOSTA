package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
 

@Controller
public class HomeController {

	@RequestMapping("/")
	public String user() {
		return "index";
	}
}
