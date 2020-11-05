package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.MelonDAO;
import model.dao.MelonDAOImpl;
import model.dto.Melon;

public class MelonService {

	public static List<Melon> selectByGrade() throws SQLException {
		MelonDAO melonDAO = new MelonDAOImpl();
		// dao를 호출하고 그결과를 리턴
		List<Melon> list = melonDAO.selectByGrade();

		return list;
	}

	public static List<Melon> selectByHits() throws SQLException {
		MelonDAO melonDAO = new MelonDAOImpl();
		// dao를 호출하고 그결과를 리턴
		List<Melon> list = melonDAO.selectByHits();

		return list;
	}

	public static List<Melon> selectByType(String type) throws SQLException {
		MelonDAO melonDAO = new MelonDAOImpl();
		// dao를 호출하고 그결과를 리턴
		List<Melon> list = melonDAO.selectByType(type);

		return list;
	}

	public static int updateHits(int resNo) throws SQLException {
		MelonDAO melonDAO = new MelonDAOImpl();
		
		int result = melonDAO.updateHits(resNo);
		
		return result;
	}

	public static List<Melon> selectByArea(String area) throws SQLException {
		MelonDAO melonDAO = new MelonDAOImpl();
		// dao를 호출하고 그결과를 리턴
		List<Melon> list = melonDAO.selectByArea(area);

		return list;
	}

	public static List<Melon> selectByResName(String resName) throws SQLException {
		MelonDAO melonDAO = new MelonDAOImpl();
		// dao를 호출하고 그결과를 리턴
		List<Melon> list = melonDAO.selectByResName(resName);

		return list;
	}
	
	
}
