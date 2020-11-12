package kosta.mvc.model.service;

import kosta.mvc.model.dto.TransferDTO;
import kosta.mvc.model.exception.MyException;

public interface TransferService {
   /**
    * 계좌이체기능
    * */
	int transfer(TransferDTO transferDTO) throws MyException;
}
