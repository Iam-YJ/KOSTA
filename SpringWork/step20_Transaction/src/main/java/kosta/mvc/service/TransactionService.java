package kosta.mvc.service;

import kosta.mvc.model.dto.TransferDTO;

public interface TransactionService {
	/**
	 * ������ü ��� ��� (���, �Ա��� �ƴ�)
	 *  ������ü = ��� + �Ա�
	 */
	void transfer(TransferDTO dto);
	
	void aa();

}
