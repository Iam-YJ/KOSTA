package kosta.web.mvc.board.dto;

import org.springframework.web.multipart.MultipartFile;

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
	private long fsize;
	
	private MultipartFile file;
	//업로드 기능 진행을 위해 MultipartFile 필요하고 
	// 이것에 대한 이름은 <input type="file" name="???">의 ???와 이름이 같아야 한다 

}
