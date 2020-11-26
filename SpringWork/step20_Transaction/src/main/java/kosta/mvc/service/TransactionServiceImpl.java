package kosta.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kosta.mvc.model.dto.TransferDTO;
import kosta.mvc.repository.TransactionDAO;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDAO dao;
	
	@Override
	@Transactional
	public void transfer(TransferDTO dto) {
		//1. ����Ѵ�
		int result = dao.withDraw(dto);
		
		int result2 = dao.deopsit(dto);
		
		//2. ����� �����ϸ� �Ա��� �Ѵ� 
		if(result ==0 || result2 == 0) {
			throw new RuntimeException("������ü �����Դϴ�");
		}
	}
	
	@Override
	public void aa() {
		
	}

}
