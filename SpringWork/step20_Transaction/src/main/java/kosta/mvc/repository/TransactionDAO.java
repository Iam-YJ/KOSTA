package kosta.mvc.repository;

import kosta.mvc.model.dto.TransferDTO;

public interface TransactionDAO {
	
	/**
	 * ����ϱ�
	 */
	int withDraw(TransferDTO dto);
	
	/**
	 * �Ա��ϱ�
	 */
	int deopsit(TransferDTO dto);
}
