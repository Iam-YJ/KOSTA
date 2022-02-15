package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController //controller + responseBody를 같이 처리하는 어노테이션  
				// 일반 요청 말고 비동기화 통신에만 이용한다 
public class ResponseBodyController {
	@RequestMapping(value = "/responseBody.do", produces = "text/html; charset=UTF-8")
	//@ResponseBody // 리턴되는 값이 그대로 응답객체이다 - ajax 할 때 필요함
	public String aa() {

		return "Response Test 리턴 입니당";
	}

	@RequestMapping(value = "/responseBody2.do", produces = "text/html; charset=UTF-8")
	//@ResponseBody
	public String bb() {
		return "이제 쉬어야겠다..";
	}
}
