package kosta.mvc.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.dto.TransferDTO;

@Repository
public class TransactionDAOImpl implements TransactionDAO {

	@Autowired
	private SqlSession session;

	@Override
	public int withDraw(TransferDTO dto) {
		int result = session.update("TransferMapper.withDraw", dto);
		return result;
	}

	@Override
	public int deopsit(TransferDTO dto) {
		return session.update("TransferMapper.deposit", dto);
	}

}
