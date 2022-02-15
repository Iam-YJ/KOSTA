package kosta.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentbDTO {
	private int commentNo;
	private String userId;
	private String commentContent;
	private  String regDate;
	
	//1 대 1인 경우
	private UserDTO user;
	
	// 1 : 다 인 경우
	private List<ReplyDTO> replies;
}
