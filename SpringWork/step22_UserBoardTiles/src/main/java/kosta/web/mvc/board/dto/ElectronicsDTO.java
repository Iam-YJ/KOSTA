package kosta.web.mvc.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ElectronicsDTO {

	private String modelNum;
	private String modelName;
	private int price;
	private String description;
	private String password;
	private String writeDay;
	private int readNum;
	private String fname;
	private int fsize;

}
