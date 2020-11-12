
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
	 * AdminDAOImpl�� ���� ��� �޼ҵ� ȣ��
	 */
	public static int insertRes(Melon melon) throws SQLException {
		int result = adminDAO.insertRes(melon);
		return result;
	}

	/**
	 * AdminDAOImpl�� ���� ���� �޼ҵ� ȣ��
	 */
	public static int deleteRes(int resNo) throws SQLException {
		int result = adminDAO.deleteRes(resNo);

		return result;

	}
	/**
	 * AdminDAOImpl�� ���� ���� �޼ҵ� ȣ��
	 */
	public static int updateRes(Melon melon) throws SQLException {
		int result = adminDAO.updateRes(melon);

		return result;

	}

	/**
	 * AdminDAOImpl�� ȸ�� ��� ���� �޼ҵ� ȣ��
	 */
	public static void manageUserGrade(String userId, String grade) throws SQLException {
		adminDAO.manageUserGrade(userId, grade);

	}
	/*
	    * AdminDAOImpl�� �������� ��ü���� �޼ҵ� ȣ��
	    * */
	   public static List<Noti> selectNoti() throws SQLException{
	      
	      
	      List<Noti> list = adminDAO.selectNoti();
	      if(list == null) {
	         throw new SQLException("�������� ��ü���� ����");
	      }//if
	      
	      return list;
	   }
	   
	   /*
	    * �������� �󼼺���
	    * */
	   public static Noti selectByNoti(int notiNo, boolean flag) throws SQLException{
	      if(flag) {
	         
	         int result = adminDAO.increamentByHits(notiNo);
	         if(result == 0 ) throw new SQLException("^^");
	      }
	      
	      Noti noti = adminDAO.selectByNoti(notiNo);
	      if(noti == null) throw new SQLException(notiNo+"���������ʽ��ϴ�");
	      return noti;
	      
	      
	   }
	
	   /**
	       * AdminDAOImpl�� �������� �ۼ� �޼ҵ� ȣ��
	       */
	      public static int insertNotice(String title, String content) throws SQLException {
	         int result = adminDAO.insertNotice(title, content);
	         
	         if(result ==0) throw new SQLException("�����մϴ�");
	         return result;

	      }

	/**
	 * AdminDAOImpl�� �������� ���� �޼ҵ� ȣ��
	 */
	public static int updateNotice(Noti notice) throws SQLException {
		int result = adminDAO.updateNotice(notice);

		return result;

	}

		/**
	    * AdminDAOImpl�� �������� ���� �޼ҵ� ȣ��
	    */
	   public static int deleteNotice(int notiNo, String path) throws SQLException {
	      System.out.println("deleteNotice ȣ��");
	      int result = adminDAO.deleteNotice(notiNo);
	      
	      if(result ==0) throw new SQLException(notiNo + "�������� ��������");
	      return result;

	   }

	/**
	 * AdminDAOImpl�� ȸ�� �߹� �޼ҵ� ȣ��
	 */
	public static int banUser(String userId) throws SQLException {
		int result = adminDAO.banUser(userId);

		return result;

	}

}