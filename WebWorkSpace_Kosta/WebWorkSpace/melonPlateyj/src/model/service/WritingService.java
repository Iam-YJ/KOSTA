package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.WritingDAO;
import model.dao.WritingDAOImpl;
import model.dto.Melon;
import model.dto.Writing;

public class WritingService {
	
	WritingDAO dao = new WritingDAOImpl();
	
	/**
	 * 식당 이름으로 검색 - 홀릭이 글 쓸 떄 식당 조회한 후 작성할 수 있도록 ? 
	 */
	public List<Melon> selectByName(String resName) throws SQLException{
		List<Melon> list = dao.selectByName(resName);
		return list;
	}
	
	/**
	 * 글 작성 
	 */
	public void insertWriting(Writing writing) throws SQLException{
		System.out.println("WritingService의 insertWriting() 메소드");
		int result = dao.insertWriting(writing);
		if(result==0) throw new SQLException("글 작성 실패");
	}
	
	/**
	 * 글 수정 
	 */
	public void updateWriting(Writing writing) throws SQLException{
		int result = dao.updateWriting(writing);
		if(result==0) throw new SQLException("글 수정 실패");
	}
	
	/**
	 * 글 삭제
	 */
	public void deleteWriting(int wriNo) throws SQLException{
		System.out.println("WritingService의 deleteWriting() 메소드");
		int result = dao.deleteWriting(wriNo);
		if(result==0) throw new SQLException("글 삭제 실패");
		System.out.println("result: " + result);
	}
	
	/**
	 * 글 조회 
	 */
	public List<Writing> selectWriting() throws SQLException{
		List<Writing> list = dao.selectWriting();
		if(list==null || list.size()==0) throw new SQLException("글 없음");
		return list;
	}

}
