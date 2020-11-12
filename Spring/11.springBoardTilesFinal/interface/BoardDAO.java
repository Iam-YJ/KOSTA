package spring.web.dao;

import java.sql.SQLException;
import java.util.List;

import spring.web.dto.ElectronicsDTO;

public interface BoardDAO{
	/**
	  * 레코드 전체 검색
	  * */
	  List<ElectronicsDTO> selectAll() ;
	  
	  /**
		  * 모델번호에 해당하는 레코드 검색
		  * */
	  ElectronicsDTO selectByModelNum(String modelNum) ;
	  
	  /**
	   * 모델번호에 해당하는 레코드 조회수 증가하기
	   * */
	  int readnumUpdate(String modelNum);
	  
	/**
	 * 레코드 삽입
	 * */
	  int insert(ElectronicsDTO electronics);
	  
	  /**
	   * 모델번호에 해당하는 레코드 삭제
	   * */
	   int delete(String modelNum, String password);
	  
	   /**
	    * 모델번호에 해당하는 레코드 수정
	    * */
	   int update(ElectronicsDTO electronics);

}
