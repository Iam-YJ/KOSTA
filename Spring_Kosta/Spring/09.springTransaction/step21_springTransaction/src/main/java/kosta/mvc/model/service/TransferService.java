package kosta.mvc.model.service;

import kosta.mvc.model.dto.TransferDTO;
import kosta.mvc.model.exception.MyException;

public interface TransferService {
   /**
    * ������ü���
    * */
	int transfer(TransferDTO transferDTO) throws MyException;
}
