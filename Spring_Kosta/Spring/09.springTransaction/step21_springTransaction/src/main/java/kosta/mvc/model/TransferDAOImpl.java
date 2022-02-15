package kosta.mvc.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.dto.TransferDTO;

@Repository
public class TransferDAOImpl implements TransferDAO {
	
	@Autowired
	private SqlSession session;

	@Override
	public int withDraw(TransferDTO transferDTO) {
		return session.update("TransferMapper.withDraw", transferDTO);
	}

	@Override
	public int deposit(TransferDTO transferDTO) {
		return session.update("TransferMapper.deposit" , transferDTO);
	}

}





