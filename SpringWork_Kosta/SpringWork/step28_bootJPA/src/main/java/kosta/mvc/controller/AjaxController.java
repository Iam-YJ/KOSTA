package kosta.mvc.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {

	@RequestMapping("/test2")
	public List<String> test2(){
		List<String> list = Arrays.asList(new String [] {"냠냠","쩝쩝","뇸뇸"});
		return list;
	}
	
}
