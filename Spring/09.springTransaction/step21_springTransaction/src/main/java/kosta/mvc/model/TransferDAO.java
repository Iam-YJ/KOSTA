package kosta.mvc.model;

import kosta.mvc.model.dto.TransferDTO;

public interface TransferDAO {
   /**
    *  출금하기
    * */
	int withDraw(TransferDTO transferDTO);
	
	/**
	 * 입금하기
	 * */
	int deposit(TransferDTO transferDTO);
}


