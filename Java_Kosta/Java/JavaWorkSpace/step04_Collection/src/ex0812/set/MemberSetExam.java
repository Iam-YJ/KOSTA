package ex0812.set;

import java.util.HashSet;

public class MemberSetExam extends HashSet<Member> {

	public MemberSetExam() {
		
		super.add(new Member("일나영", 10));
		super.add(new Member("이나영", 20));
		super.add(new Member("일나영", 10));

		//이것은 size가 3개 나올 것이다
		
		//왜냐면 - 주소값이 다 다르기 때문이다
		//이는 hashCode()를 통해 자동으로 판단한다
		//hashCode() - 같다 - equals()로 비교
		//			
		System.out.println("총 개수 : " + super.size());

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
