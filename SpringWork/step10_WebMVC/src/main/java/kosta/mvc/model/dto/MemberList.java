package kosta.mvc.model.dto;

import java.util.List;

public class MemberList {

	private List<Member> list; //<input type="" name="list[index]"/>
//MemberListProperty���� ����� list �̸��� ���Ƽ� �˾Ƽ� ������ ����
	
	public List<Member> getList() {
		return list;
	}

	public void setList(List<Member> list) { //��ü�� �����ؼ� ���� 
											//new ArrayList�� 
		System.out.println("setList(List<Member> list) ȣ���");
		this.list = list;
	}
	
	
	
}
