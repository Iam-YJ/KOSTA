package kosta.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kosta.dto.ProductList;

public class ProductDAO {

	/**
	 * 동적 쿼리(if문과 where, trim)
	 */

	public static List<ProductList> ifTest(ProductList dto) {
		SqlSession session = DbUtil.getSession();
		List<ProductList> list = null;

		try {

			list = session.selectList("dynamicMapper.ifSelect", dto);

		} finally {
			DbUtil.sessionClose(session);
		}

		return list;
	}
	
	
	/**
	 * updateTest
	 */

	
	  public static boolean updateTest(ProductList dto) { 
		  SqlSession session =null; 
		  boolean result = false;
	  
	  try {
	  
	  session = DbUtil.getSession(); result =
	  session.update("dynamicMapper.update", dto) > 0 ? true : false;
	  
	  } finally { DbUtil.sessionClose(session, result); }
	  
	  return result; 
	 }
	 
	  
		/**
		 * delete
		 */

		
		  public static boolean deleteTest(ProductList dto) { 
			  SqlSession session =null; 
			  boolean result = false;
		  
		  try {
		  
		  session = DbUtil.getSession(); result =
		  session.update("dynamicMapper.delete", dto) > 0 ? true : false;
		  
		  } finally { DbUtil.sessionClose(session, result); }
		  
		  return result; 
		 }

		  
		  /**
		   * sum 출력
		   */
		  public static int sumTest(ProductList dto) {
				SqlSession session = DbUtil.getSession();
				int sum = 0;

				try {

					sum = session.selectOne("dynamicMapper.sum", dto);

				} finally {
					DbUtil.sessionClose(session);
				}

				return sum;
			}
		  
	/**
	 * forEach
	 */
	
	  public static List<ProductList> forEachTest(List<String> paramList) {
		  SqlSession session = null; 
		  List<ProductList> list = null;
	  
	  try {
	  
	  session = DbUtil.getSession(); 
	  list = session.selectList("dynamicMapper.forSelect", paramList);
	  
	  } finally { DbUtil.sessionClose(session); }
	  
	  return list; }
	 
}
