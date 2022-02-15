package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.Melon;
import model.dto.Noti;
import model.service.AdminService;


public class AdminController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ���� ��� �޼ҵ� ȣ��
	 */
	public ModelAndView insertRes(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AdminController�� insertRes ȣ��Ǿ����ϴ�");

		String resName = request.getParameter("resName");
		String resTel = request.getParameter("resTel");
		String resLoc = request.getParameter("resLoc");
		String resLocDetail = request.getParameter("resLocDetail");
		String resKind = request.getParameter("resKind");
		String resMenu = request.getParameter("resMenu");
		String resPrice = request.getParameter("resPrice");
		String resPhoto = request.getParameter("resPhoto");
		String resPlace = resLoc + resLocDetail;

		/*
		 * System.out.println(resName); System.out.println(resTel);
		 * System.out.println(resLoc); System.out.println(resLocDetail);
		 * System.out.println(resKind); System.out.println(resMenu);
		 * System.out.println(resPrice); System.out.println(resPhoto);
		 * System.out.println(resPlace);
		 */

		Melon melon = new Melon(resName, resPlace, resTel, resKind, resPhoto, resPrice);

		AdminService.insertRes(melon);

		ModelAndView mv = new ModelAndView("html/admin_section/add-listing-with-menu-list.jsp", true);

		return mv;
		// new ModelAndView(request.getContextPath() +
		// "/add-listing-with-menu-list.html", false);

	}


	/**
	 * ���� ���� �޼ҵ� ȣ��
	 */

	public ModelAndView deleteRes(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("AdminController�� deleteRes ȣ��Ǿ����ϴ�");
		String resNo = request.getParameter("resResultNo");
		//int resNoo = Integer.parseInt(resNo);
		AdminService.deleteRes(Integer.parseInt(resNo));
		System.out.println(Integer.parseInt(resNo));
		return new ModelAndView("./dispatcher?key=melon&methodName=selectByArea", true);
	}


	/**
	 * ���� ���� �޼ҵ� ȣ��
	 */

	public ModelAndView updateRes(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("AdminController�� updateRes ȣ��Ǿ����ϴ�");
		return new ModelAndView("index.jsp", true);
	}

	/**
	 * ȸ�� ��� ���� �޼ҵ� ȣ��
	 */

	public ModelAndView manageUserGrade(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("AdminController�� manageUserGrade ȣ��Ǿ����ϴ�");
		return new ModelAndView("index.jsp", true);
	}

	  /**
	    * �������� �ۼ� �޼ҵ� ȣ��
	    */

	  public ModelAndView insertNotice(HttpServletRequest request, HttpServletResponse response) throws Exception{
	         System.out.println("AdminController�� insertNotice ȣ��Ǿ����ϴ�");
	         
	         String notiTitle = request.getParameter("notiTitle");
	         String notiContent = request.getParameter("notiContent");
	         System.out.println("notiTitle : " + notiTitle);
	         System.out.println("notiContent : " + notiContent);
	         //Noti noti = new Noti(0, notiTitle, notiContent);
	      
	         AdminService.insertNotice(notiTitle, notiContent);
	         
	         ModelAndView mv = new ModelAndView("dispatcher?key=admin&methodName=selectNoti",true);
	         
	         return mv;
	      }
	   
	   /*
	    * �������� ��ü����
	    */

	   public ModelAndView selectNoti(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      System.out.println("AdiminController�� selectNoti ȣ��Ǿ����ϴ�");

	      List<Noti> list = AdminService.selectNoti();
	      request.setAttribute("list", list);

	      System.out.println("list : " + list);
	      String url = "html/admin_section/board.jsp";

	      ModelAndView mv = new ModelAndView();
	      mv.setViewName(url);
	      return mv;

	   }  
	   
	 
	/**
	 * �������� ���� �޼ҵ� ȣ��
	 */

	public ModelAndView updateNotice(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("AdminController�� updateNotice ȣ��Ǿ����ϴ�");
		return new ModelAndView("index.jsp", true);
	}

	  /**
	    * �������� ���� �޼ҵ� ȣ��
	    */

	   public ModelAndView deleteNotice(HttpServletRequest request, HttpServletResponse response) throws Exception{
	      System.out.println("AdminController�� deleteNotice ȣ��Ǿ����ϴ�");
	      
	      String notiNo = request.getParameter("notiNo");
	      String path = request.getServletContext().getRealPath("/save");
	      
	      AdminService.deleteNotice(Integer.parseInt(notiNo), path);
	      ModelAndView mv = new ModelAndView("dispatcher?key=admin&methodName=selectNoti", true);
	      return mv;
	   }

	/**
	 * ȸ�� �߹� �޼ҵ� ȣ��
	 */

	public ModelAndView banUser(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("AdminController�� banUser ȣ��Ǿ����ϴ�");
		return new ModelAndView("index.jsp", true);
	}

}
