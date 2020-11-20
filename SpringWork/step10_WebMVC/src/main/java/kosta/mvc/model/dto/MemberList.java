package kosta.mvc.model.dto;

import java.util.List;

public class MemberList {

	private List<Member> list; //<input type="" name="list[index]"/>
//MemberListProperty에서 사용한 list 이름과 같아서 알아서 들어오는 것임
	
	public List<Member> getList() {
		return list;
	}

	public void setList(List<Member> list) { //객체를 생성해서 담음 
											//new ArrayList로 
		System.out.println("setList(List<Member> list) 호출됨");
		this.list = list;
	}
	
	
	
}
