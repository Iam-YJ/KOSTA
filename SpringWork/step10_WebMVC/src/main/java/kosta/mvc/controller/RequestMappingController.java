package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rem") // rem밑으로 들어오는 하위만 받아들이게 함
public class RequestMappingController {

	/**
	 * 리턴타입 String : 리턴되는 문자열이 뷰의 이름이 된다
	 */
	@RequestMapping("/a.do") // rem 밑으로 a.do라고 요청이 들어오면
	public String aa() {
		System.out.println("rem/a.do 요청이 되었습니다");

		return "result"; // WEB-INF/views/result.jsp 이동
	}

	/**
	 * b.do 또는 c.do 요청이 하나의 메소드 실행
	 * 
	 * 리턴타입이 void인 경우 : 요청된 주소가 view 이름이 된다 
	 * ex) rem/a.do가 요청되면 뷰의 이름은 rem/a => 최종 뷰 정보는 /WEB-INF/views/rem/a.jsp가 된다
	 * 
	 */
	@RequestMapping(value = { "/b.do", "c.do" }) // rem 밑으로 a.do라고 요청이 들어오면
	public void bb() {
		System.out.println("rem/b.do 또는 rem/c.do 요청 요청이 되었습니다");
		// 파일 [/WEB-INF/views/rem/b.jsp]을(를) 찾을 수 없습니다.
		// 파일 [/WEB-INF/views/rem/c.jsp]을(를) 찾을 수 없습니다.

	}

	// @RequestMapping(value = "/test.do", method = RequestMethod.GET) // rem 밑으로
	// a.do라고 요청이 들어오면
	@GetMapping("/test.do")
	public String test(HttpServletRequest request) {
		String name = request.getParameter("name");

		System.out.println("/test.do 요청이 되었습니다.. GET 방식");
		System.out.println("name = " + name);

		return "result"; // WEB-INF/views/result.jsp 로 이동

	}

	// @RequestMapping(value = "/test.do", method = RequestMethod.POST) // rem 밑으로
	// a.do라고 요청이 들어오면
	@PostMapping("/test.do")
	public String test2(String name) {
		System.out.println("/test.do 요청이 되었습니다 ... POST 방식");
		System.out.println("name = " + name);

		return "result"; // WEB-INF/views/result.jsp 로 이동

	}
	
	
	/**
	 * parameter 정보에 따라 실행되는 메소드를 다르게
	 * 
	 */
	//@RequestMapping(value = "/a.do" , params= {"id"})
	@RequestMapping(value = "/a.do" , params= {"id=jang"})
	//@RequestMapping(value = "/a.do" , params= {"id","age"})
	//@RequestMapping(value = "/a.do" , params= {"id != jang"})
	public ModelAndView aaa() {
		System.out.println("params의 정보로 test 중입니다");
		
		return new ModelAndView("result"); // WEB-INF/views/result.jsp 이동 
	}
}
