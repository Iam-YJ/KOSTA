package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.Melon;
import model.dto.Noti;

public class AdminController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 *  맛집 등록 메소드 호출
	 */
	public ModelAndView insertRes(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("AdminController의 insertRes 호출되었습니다");
		String id = request.getParameter("form-control");
		System.out.println("id = "+id);
		
		return new ModelAndView(request.getContextPath()+"/add-listing-with-menu-list.html", false);
	}

	/**
	 * 맛집 삭제 메소드 호출
	 */

	public ModelAndView deleteRes(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("AdminController의 deleteRes 호출되었습니다");
		return new ModelAndView("index.jsp", true);
	}
	
	
	/**
	 * 맛집 수정 메소드 호출
	 */
	
	public ModelAndView updateRes(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("AdminController의 updateRes 호출되었습니다");
		return new ModelAndView("index.jsp", true);
	}


	/**
	 *회원 등급 관리 메소드 호출
	 */
	
	public ModelAndView manageUserGrade(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("AdminController의 manageUserGrade 호출되었습니다");
		return new ModelAndView("index.jsp", true);
	}


	/**
	 * 공지사항 작성 메소드 호출
	 */
	
	public ModelAndView insertNotice(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("AdminController의 insertNotice 호출되었습니다");
		return new ModelAndView("index.jsp", true);
	}

	/**
	 * 공지사항 수정 메소드 호출
	 */
	
	public ModelAndView updateNotice(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("AdminController의 updateNotice 호출되었습니다");
		return new ModelAndView("index.jsp", true);
	}


	/**
	 * 공지사항 삭제 메소드 호출
	 */
	
	public ModelAndView deleteNotice(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("AdminController의 deleteNotice 호출되었습니다");
		return new ModelAndView("index.jsp", true);
	}


	/**
	 * 회원 추방 메소드 호출
	 */
	
	public ModelAndView banUser(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("AdminController의 banUser 호출되었습니다");
		return new ModelAndView("index.jsp", true);
	}

	
	
}
