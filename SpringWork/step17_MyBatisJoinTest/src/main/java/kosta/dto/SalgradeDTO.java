package kosta.dto;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SalgradeDTO {

	private int grade;
	private int losal;
	private int hisal;
	
	private List<EmpDTO> empList;
}
