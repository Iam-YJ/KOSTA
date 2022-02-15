package kosta.mvc.controller;

import org.springframework.stereotype.Controller;import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathVariableController {
	
	@RequestMapping(value= "/{type}/{id}.do")
	//depth 2단계로 들어오는 애들이 다 들어온다 
	public String aa(@PathVariable String type,@PathVariable String id) { //type=값 & id=값
		//@PathVariable이 있으면 path의 애들을 값으로 쓸거다
		// 					없으면 parameter로 쓸거다
		System.out.println("/{type}/{id}.do 가 요청되었습니다");
		System.out.println("type = "+type+", id = "+id);
			
		return "result";
	}
	
	@RequestMapping(value="/{user}") //	<url-pattern>/blog/*</url-pattern> 이라고 web.xml에서 설정했기 때문에 * 아래만 적으면 된다
	public String bb(@PathVariable String user) {
		System.out.println("blog/* 요청되었습니당");
		System.out.println("user = "+user);
		return "result";
	}
	
	@RequestMapping(value="/{kind}/{name}/{no}")
	public String cc(@PathVariable String kind, @PathVariable String name, @PathVariable String no) {
		System.out.println("kind = "+kind+", name = "+name+", no = "+no);
		return "result";
		
		
		//단 <a href="user/borad/bbs/3">요청4</a> 으로 들어오는 것은 오류 
		// user 밑으로 들어오게 하는 것을 설정하지 않았기 때문
	}
	
	@RequestMapping("/{url}.do")
	public void aaa() {
		//이것을 사용함으로써 원하는 페이지로 이동할 수 있게 한다
		//url 주소가 바뀌어도 그것이 다 페이지명으로 갈 수 있게 한다
		//예시로 http://localhost:8000/controller/user.do 로 요청하면 =>  [/WEB-INF/views/user.jsp] 로 가려고한다
		System.out.println("!11");
	}

}
