package kosta.mvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.model.dto.ProductDTO;

@Controller
public class BoardController {

	@RequestMapping("/left.board")
	public ModelAndView select() {
		System.out.println("BoardController select »£√‚µ ");

		ModelAndView mv = new ModelAndView();


		mv.setViewName("left");

		return mv;
	}

}
