package kosta.mvc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransferDTO {
	private String output; // 출금계좌번호
	private String input;// 입금계좌번호
	private int transferAmount;// 계좌이체 할 금액

}
