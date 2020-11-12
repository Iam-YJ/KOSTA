package controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.Melon;
import model.dto.Noti;
import model.dto.User;
import model.service.UserService;

	public class UserController implements Controller {

	UserService service = new UserService();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("UserController당");
		return null;
	}

	public ModelAndView join(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("UserController안 join 호출");
		String userNo = request.getParameter("userNo");
		String userNick = request.getParameter("userNick");
		String userAge = request.getParameter("userAge");
		String userEmail = request.getParameter("userEmail");
		String userGender = request.getParameter("userGender");

		/*
		 * System.out.println("userNo = "+ userNo); System.out.println("userNick = "+
		 * userNick); System.out.println("userAge = "+ userAge);
		 * System.out.println("userEmail = "+ userEmail);
		 * System.out.println("userGender = "+ userGender);
		 */

		if (userGender.equals("female")) {
			userGender = "여";
		} else {
			userGender = "남";
		}

		service.joinKakao(Integer.parseInt(userNo), userNick, userAge, userEmail, userGender);

		return new ModelAndView("./html/index.jsp", true);
	}

	 /**
	    * 찜하기 추가
	    */
	   public ModelAndView insertBookMark(HttpServletRequest request, HttpServletResponse response) {
	      System.out.println("userController의 insertBookMark() 메소드");
	      String userNo = request.getParameter("user_no");
	      String resNo = request.getParameter("res_no");
	      
	      //System.out.println(userNo);
	      
	      service.insertBookMark(Integer.parseInt(userNo), Integer.parseInt(resNo));
	      
	      //ModelAndView mv = new ModelAndView("dispatcher", true);
	      
	      return new ModelAndView("dispatcher?key=melon&methodName=selectDetailRes&resNo="+resNo, true);
	   }

	   /**
	    * 찜하기 삭제 
	    */
	   public ModelAndView deleteBookMark(HttpServletRequest request, HttpServletResponse response) {
	      //찜하기 삭제 후 찜하기 목록보기 페이지로 이동
	      System.out.println("deleteBookMark() 메소드");
	      String userNo = request.getParameter("user_no");
	      String resNo = request.getParameter("res_no");
	      System.out.println("userNo: " + userNo);
	      System.out.println("resNo: " + resNo);
	      
	      service.deleteBookMark(Integer.parseInt(userNo), Integer.parseInt(resNo));
	      
	      return new ModelAndView("dispatcher?key=user&methodName=seleteBookMark&user_no="+Integer.parseInt(userNo), true);
	   }

	   /**
	    * 찜하기 조회 
	    */
	   public ModelAndView seleteBookMark(HttpServletRequest request, HttpServletResponse response) throws SQLException{
	      //찜하기 목록보기로 이동 
	      
	      System.out.println("selectBookMark() 메소드");
	      
	      String userNo = request.getParameter("user_no");
	      System.out.println("userNo: " + userNo);
	      List<Melon> list = service.selectBookMark(Integer.parseInt(userNo));
	      request.setAttribute("list", list);
	      System.out.println(list);
	      
	      return new ModelAndView("html/user_page/bookmarks.jsp", false);
	   }

	   /**
	    * 포인트 증가 
	    */
	   public ModelAndView updatePoint(HttpServletRequest request, HttpServletResponse response) {
	      
	      String userNo = request.getParameter("user_no");
	      String point = request.getParameter("point");
	      
	      service.updatePoint(Integer.parseInt(userNo), Integer.parseInt(point));
	      
	      ModelAndView mv = new ModelAndView("dispatcher", true);
	      
	      return mv;
	   }
	   
	   /**
	    *  회원정보 조회
	    * */
	   public ModelAndView selectUserInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      System.out.println("UserController selectUserInfo() 메소드");
	      String userNo = request.getParameter("user_no");
	      
	      User user = service.selectUserInfo(Integer.parseInt(userNo));
	      request.setAttribute("user", user);

	      return new ModelAndView("html/user_page/index.jsp", false);
	   }
	   
	   

	   /**
	    *  회원정보수정
	    * */
	   public ModelAndView updateUserInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      System.out.println("updateUserInfo() 메소드");
	      String nickname =request.getParameter("new_nickname");
	      String email = request.getParameter("new_email");
	      String prefer = request.getParameter("new_prefer");
	      String userNo = request.getParameter("user_no");
	      
	      System.out.println("nickname: " + nickname);
	      System.out.println("email: " + email);
	      System.out.println("prefer: " + prefer);
	      System.out.println("userNo: " + userNo);
	      
	      User user = new User(nickname, email, prefer, Integer.parseInt(userNo));
	      service.updateUserInfo(user);
	      
	      return new ModelAndView("dispatcher?key=user&methodName=selectUserInfo&user_no="+Integer.parseInt(userNo), true);
	   }
	   
	   

	   /**
	    * 유저입장 공지사항 조회
	    * */
	   public ModelAndView selectNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      
	      List<Noti> list = service.selectNotice();
	      request.setAttribute("list", list);
	      
	      return new ModelAndView("html/user_page/notice.jsp", false);
	   }
	   
	   /**
	    * 공지사항 내용 보기
	    */
	   public ModelAndView selectNotiByNotiNo(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      System.out.println("userController 공지사항상세보기");
	      String notiNo = request.getParameter("noti_no");
	      System.out.println("notiNo: " + notiNo);
	      Noti noti = service.selectNotiByNotiNo(Integer.parseInt(notiNo));
	      System.out.println("noti: " + noti);
	      request.setAttribute("noti", noti);
	      
	      return new ModelAndView("html/user_page/notice-detail.jsp", false);
	   }

	   /**
	    * 관심분야 추가
	    */
	   public ModelAndView interestInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      System.out.println("UserController 안 interestInsert 입니당");
	      String[] iList = request.getParameterValues("interests");
	      int result = service.interestInsert(iList);

	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("/melonPlate/html/user_page/user-profile.jsp");
	      mv.setRedirect(true);
	      return mv;
	   }
	   
	   
	   /**
		 * 미니테스트..
		 */
		public ModelAndView miniTest(HttpServletRequest request, HttpServletResponse response) throws Exception {
			System.out.println("UserController 안 miniTest 입니당");
			String[] iList = request.getParameterValues("interests");

			ModelAndView mv = new ModelAndView();

			if (iList[0].equals("a")) {
				if (iList[1].equals("c")) {
					mv.setViewName("/melonPlateyj/html/user_page/apo.jsp");
				} else if (iList[1].equals("d")) {
					mv.setViewName("/melonPlateyj/html/user_page/rice.jsp");
				}
			} else if (iList[0].equals("b")) {
				if (iList[1].equals("c")) {
					mv.setViewName("/melonPlateyj/html/user_page/mara.jsp");
				} else if (iList[1].equals("d")) {
					mv.setViewName("/melonPlateyj/html/user_page/ozzing.jsp");
				}
			}

			mv.setRedirect(true);
			return mv;
		}
	}

	