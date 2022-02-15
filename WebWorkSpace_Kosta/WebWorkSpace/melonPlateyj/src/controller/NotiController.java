package controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.Noti;
import model.service.AdminService;

public class NotiController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	 /**
	   * 공지사항 전체보기
	   * */
	   
	   public ModelAndView selectNoti(HttpServletRequest request, HttpServletResponse response) throws Exception{
		   System.out.println("NotiController의 selectNoti 호출되었습니다");
		   List<Noti> list = AdminService.selectNoti();
		   String id = request.getParameter("form-control");
		   System.out.println("id =" + id);
		   request.setAttribute("list", list);
		   
		   return new ModelAndView(request.getContextPath() + "../html/admin_section/index.html", false);
	   }

}
