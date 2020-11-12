package kosta.mvc.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kosta.mvc.model.TransferDAO;
import kosta.mvc.model.dto.TransferDTO;
import kosta.mvc.model.exception.MyException;

@Service
//@Transactional
@Transactional(propagation=Propagation.REQUIRED , 
               isolation=Isolation.DEFAULT)
public class TransferServiceImpl implements TransferService {
	@Autowired
	private TransferDAO transferDAO;
	
	@Override
	public int transfer(TransferDTO transferDTO) throws MyException {
		int re1 = transferDAO.withDraw(transferDTO);
		int re2 = transferDAO.deposit(transferDTO);
		if(re1 ==0 || re2==0)
			throw new MyException("계좌이체 되지 않았습니다.");
		return 1;
	}
	

}






