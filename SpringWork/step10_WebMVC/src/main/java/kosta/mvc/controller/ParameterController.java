package kosta.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kosta.mvc.model.dto.Member;

@Controller
@RequestMapping("/param")
public class ParameterController {
	
	//값이 넘어오는 것을 getParameter로 받아도 되고 함수로 받아도 된다
	//값이 여러개 한번에 넘어오는 것은 .. 

	/*
	 * @RequestMapping("/a.do") public ModelAndView aa(HttpServletRequest request) {
	 * 
	 * String name = request.getParameter("name"); int age =
	 * Integer.parseInt(request.getParameter("age"));
	 * 
	 * System.out.println("name = "+name+" age = "+age);
	 * 
	 * return new ModelAndView("result", "message", "parameterController 입니당 "); }
	 */

	
	/**
	 * 매개변수로 전달받은 Model 객체는 뷰쪽으로 전달될 객체이다
	 * 매개변수 Model에 정보를 저장하면 뷰에서 사용할 수 있다
	 * 
	 * 
	 */
	@RequestMapping("/a.do")
	public String aa(String name, Integer age, Model model) {
		System.out.println(name + ", " + age);
		//null이라는 값은 int에 담을 수 없다  => Integer
		
		model.addAttribute("message","매개변수 model");

		
		return "result"; // WEB-INF/views/result.jsp
	}
	
	/**
	 * void는 뷰의 정보가 param/c.jsp로 이동한다
	 * 
	 * parameter로 전달되는 name과 동일한 속성들을 가지고 있는 객체를 인수로 선언하면
	 * 그 객체를 생성해서 setXxx() 으로 데이터로 저장해준다 
	 * 
	 * parameter로 전달된 정보를 객체로 바인딩하면 그 객체를 
	 * view에 가서 그대로 사용할 수 있다. - Model 정보에 저장이 된다
	 * => 사용방법은 뷰에서 사용할 때 객체이름의 첫글자를 소문자로 변경해서 
	 *  즉, Member이면 member로 사용한다 ${member.id}
	 *  
	 *  
	 *  
	 *  @ModelAttribute를 매개변수에 선언하면
	 *  객체의 별칭을 만들어서 사용할 수 있다.
	 *  이렇게 하면 뷰 페이지에 가서 별칭으로 간단하게 접근 할 수 있다.
	 *  
	 */
	@PostMapping("/c.do")
	public void c(@ModelAttribute("m") Member member) {
		System.out.println(member.getAddr());
		System.out.println(member.getAge());
		System.out.println(member.getId());
		System.out.println(member.getName());
	}
	
	
	@ModelAttribute("hobbys") //뷰에서 ${hobbys} 사용
	//지금 사용하는 컨트롤러를 들렸다 가는 애들만 사용 가능 
	public List<String> hobby(){
		List<String> list = new ArrayList<String>();
		list.add("등산");
		list.add("수영");
		list.add("낚시");
		list.add("접영");
		
		return list;
		
	}
	
	@ModelAttribute("addr") //${addr}
	public String addr() {
		return "경기도 성남시";
	}

}
