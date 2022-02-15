package sample10;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//id는 기본적으로 클래스이름의 첫글자만 소문자.. 
@Component // <bean class="BoardDTO" id="boardDTO" /> 동일
@Scope("prototype")
public class BoardDTO {

	@Value("10")
	private int no;

	@Value("spring")
	private String subject;

	@Value("재밌당")
	private String content;

	public BoardDTO() {

	}

	public BoardDTO(int no, String subject, String content) {
		super();
		this.no = no;
		this.subject = subject;
		this.content = content;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
