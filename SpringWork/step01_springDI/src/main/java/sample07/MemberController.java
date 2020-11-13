package sample07;

public class MemberController {
	private MemberVO member;
	private MemberVO memberVO;

	public MemberController() {
		System.out.println("MemberController의 기본생성자");
	}

	public MemberController(MemberVO member, MemberVO memberVO) {

		System.out.println("MemberController(MemberVO member, MemberVO memberVO)의 기본생성자");
		this.member = member;
		this.memberVO = memberVO;
	}

	public MemberVO getMember() {
		return member;
	}

	public void setMember(MemberVO memberVO) {
		System.out.println("setMember(MemberVO member) 호출됨   MemberVO = " + memberVO);
		this.member = member;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO member) {
		System.out.println("setMemberVO(MemberVO member) 호출됨   member = " + member);
		this.memberVO = memberVO;
	}

}
