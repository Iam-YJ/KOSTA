package kosta.mvc.service;

import kosta.mvc.model.dto.TransferDTO;

public interface TransactionService {
	/**
	 * 계좌이체 라는 기능 (출금, 입금이 아님)
	 *  계좌이체 = 출금 + 입금
	 */
	void transfer(TransferDTO dto);
	
	void aa();

}
