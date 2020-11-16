package kosta.exam;

public class MemberServiceImpl implements MemberService {

	@Override
	public int insert() {
		System.out.println("MemberServiceImpl의 insert 핵심기능입니다");
		return 1;
	}

	@Override
	public String select(int i) {
		System.out.println("MemberServiceImpl의 select 핵심기능입니다");
		if(i==0) throw new RuntimeException("예외가 발생했어요");
		return "화장실";
	}

	@Override
	public void update(String id) {
		System.out.println("MemberServiceImpl의 update 핵심기능입니다");

	}

}
