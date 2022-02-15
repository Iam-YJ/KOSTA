package kosta.mvc.controller;

//���� ���ϴ�...
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.model.dto.ProductDTO;
import kosta.mvc.model.exception.MyErrorException;
import kosta.mvc.model.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService service;

	@RequestMapping("/index.kosta")
	public ModelAndView select() {
		System.out.println("controller select ȣ���");

		List<ProductDTO> list = service.select();
		ModelAndView mv = new ModelAndView();

		mv.addObject("list", list);
		mv.setViewName("productList");

		return mv;
	}

	/*
	 * @RequestMapping("/insertForm.kosta") public ModelAndView insertForm() throws
	 * Exception { ModelAndView mv = new ModelAndView();
	 * mv.setViewName("insertForm");
	 * 
	 * return mv; }
	 */

	@RequestMapping("/insert.kosta")
	public ModelAndView insert(ProductDTO product) throws MyErrorException {

		service.insert(product);

		ModelAndView mv = new ModelAndView();

		List<ProductDTO> list = service.select();

		mv.addObject("list", list);
		mv.setViewName("productList");

		return mv;
	}

	@RequestMapping("/{code}")
	public ModelAndView delete(@PathVariable String code) throws MyErrorException { // ?code=A01

		System.out.println(code);

		int result = service.delete(code);

		ModelAndView mv = new ModelAndView();

		if (result == 1) {
			List<ProductDTO> list = service.select();
			mv.addObject("list", list);
			mv.setViewName("redirect:/index.kosta");
		}

		return mv;
	}

	/**
	 * �󼼺���
	 */
	@RequestMapping("/detail.kosta")
	public void detail(String code, Model model) throws MyErrorException {

		System.out.println("Con detail ��");

		ProductDTO dto = service.searchByCode(code);
		model.addAttribute("dto",dto); //�信�� ${dto.code} ��밡��

	}

	//////////////////////////////////////////////////
	/**
	 * ��ǰ��� �� (�� �������� ���� ���Ҹ�!)
	 */
	@RequestMapping("{url}.kosta")
	public void url() {

	}

	/**
	 * ��ǰ����ϱ�
	 * 
	 * @throws MyErrorException
	 * 
	 */
	/*
	 * @PostMapping("/insert.kosta") public String insert1(ProductDTO productDto)
	 * throws MyErrorException { service.insert(productDto);
	 * 
	 * return "redirect:index.kosta"; }
	 */

	@ExceptionHandler(value = MyErrorException.class)
	public ModelAndView error(MyErrorException e) {
		return new ModelAndView("error", "errMessage", e.getMessage());
	}
}
