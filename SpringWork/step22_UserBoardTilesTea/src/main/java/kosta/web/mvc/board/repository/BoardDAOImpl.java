package kosta.web.mvc.board.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.web.mvc.board.dto.ElectronicsDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {
    @Autowired
	private  SqlSession session;
	
	@Override
	public List<ElectronicsDTO> selectAll() {
		return session.selectList("electronicsMapper.selectAll");
	}

	@Override
	public ElectronicsDTO selectByModelNum(String modelNum) {
		// TODO Auto-generated method stub
		return session.selectOne("electronicsMapper.selectAll" , modelNum);
	}

	@Override
	public int readnumUpdate(String modelNum) {
		return  session.update("electronicsMapper.readnumUpdate", modelNum);
	}

	@Override
	public int insert(ElectronicsDTO electronics) {
		return session.insert("electronicsMapper.insert", electronics);
	}
	

	@Override
	public int delete(String modelNum, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("modelNum", modelNum);
		map.put("password", password);
		
		return session.delete("electronicsMapper.delete", map);
	}

	@Override
	public int update(ElectronicsDTO electronics) {
		return session.update("electronicsMapper.update", electronics);
	}

}//BoardDAOImpl