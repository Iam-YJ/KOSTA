package kosta.web.mvc.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.web.mvc.exception.AutenticationException;
import kosta.web.mvc.user.dto.UserDTO;
import kosta.web.mvc.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 로그인 폼
	 */
	@RequestMapping("/login")
	public String login() {
		
		return "user/login";
	}
	
	/**
	 * 로그인 하기
	 */
	@RequestMapping("/loginCheck")
	public String loginCheck(UserDTO userDTO, HttpSession session) {
		//서비스 호출
		UserDTO dbDTO = userService.loginCheck(userDTO);
		
		//성공하면 세션에 정보를 저장한다 (${loginUser} / ${loginName})
		session.setAttribute("loginUser", dbDTO.getUserId()); //아이디 - 이것은 login.jsp에서 가져올 수 있음
		session.setAttribute("loginName", dbDTO.getName()); //이름 - 이것은 DB에서 SELECT를 사용해서 가져와야함
		
		return "redirect:/"; //루트를 따라가라.. 라는 대충 이런 뜻
	}
	
	@ExceptionHandler(AutenticationException.class)
	public ModelAndView error(AutenticationException e) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/errorMessage");
		mv.addObject("errorMsg",e.getMessage());
		return mv;
	}
	
	/**
	 * 로그아웃
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
}
