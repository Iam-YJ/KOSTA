package kosta.mvc.model;

import kosta.mvc.model.dto.TransferDTO;

public interface TransferDAO {
   /**
    *  ����ϱ�
    * */
	int withDraw(TransferDTO transferDTO);
	
	/**
	 * �Ա��ϱ�
	 * */
	int deposit(TransferDTO transferDTO);
}


