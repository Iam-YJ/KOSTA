
package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.AdminDAO;
import model.dao.AdminDAOImpl;
import model.dto.Melon;
import model.dto.Noti;

public class AdminService {
	private static AdminDAO adminDAO = new AdminDAOImpl();

	/**
	 * AdminDAOImpl의 맛집 등록 메소드 호출
	 */
	public static int insertRes(Melon melon) throws SQLException {
		int result = adminDAO.insertRes(melon);
		return result;
	}

	/**
	 * AdminDAOImpl의 맛집 삭제 메소드 호출
	 */
	public static int deleteRes(int resNo) throws SQLException {
		int result = adminDAO.deleteRes(resNo);

		return result;

	}
	/**
	 * AdminDAOImpl의 맛집 수정 메소드 호출
	 */
	public static int updateRes(Melon melon) throws SQLException {
		int result = adminDAO.updateRes(melon);

		return result;

	}

	/**
	 * AdminDAOImpl의 회원 등급 관리 메소드 호출
	 */
	public static void manageUserGrade(String userId, String grade) throws SQLException {
		adminDAO.manageUserGrade(userId, grade);

	}
	/*
	    * AdminDAOImpl의 공지사항 전체보기 메소드 호출
	    * */
	   public static List<Noti> selectNoti() throws SQLException{
	      
	      
	      List<Noti> list = adminDAO.selectNoti();
	      if(list == null) {
	         throw new SQLException("공지사항 전체보기 오류");
	      }//if
	      
	      return list;
	   }
	   
	   /*
	    * 공지사항 상세보기
	    * */
	   public static Noti selectByNoti(int notiNo, boolean flag) throws SQLException{
	      if(flag) {
	         
	         int result = adminDAO.increamentByHits(notiNo);
	         if(result == 0 ) throw new SQLException("^^");
	      }
	      
	      Noti noti = adminDAO.selectByNoti(notiNo);
	      if(noti == null) throw new SQLException(notiNo+"존재하지않습니다");
	      return noti;
	      
	      
	   }
	
	   /**
	       * AdminDAOImpl의 공지사항 작성 메소드 호출
	       */
	      public static int insertNotice(String title, String content) throws SQLException {
	         int result = adminDAO.insertNotice(title, content);
	         
	         if(result ==0) throw new SQLException("존재합니다");
	         return result;

	      }

	/**
	 * AdminDAOImpl의 공지사항 수정 메소드 호출
	 */
	public static int updateNotice(Noti notice) throws SQLException {
		int result = adminDAO.updateNotice(notice);

		return result;

	}

		/**
	    * AdminDAOImpl의 공지사항 삭제 메소드 호출
	    */
	   public static int deleteNotice(int notiNo, String path) throws SQLException {
	      System.out.println("deleteNotice 호출");
	      int result = adminDAO.deleteNotice(notiNo);
	      
	      if(result ==0) throw new SQLException(notiNo + "공지사항 삭제오류");
	      return result;

	   }

	/**
	 * AdminDAOImpl의 회원 추방 메소드 호출
	 */
	public static int banUser(String userId) throws SQLException {
		int result = adminDAO.banUser(userId);

		return result;

	}

}