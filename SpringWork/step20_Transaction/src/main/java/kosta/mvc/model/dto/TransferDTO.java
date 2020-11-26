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
	private String output; // ��ݰ��¹�ȣ
	private String input;// �Աݰ��¹�ȣ
	private int transferAmount;// ������ü �� �ݾ�

}
