package ex0812.set;

import java.util.HashSet;

public class MemberSetExam extends HashSet<Member> {

	public MemberSetExam() {
		
		super.add(new Member("�ϳ���", 10));
		super.add(new Member("�̳���", 20));
		super.add(new Member("�ϳ���", 10));

		//�̰��� size�� 3�� ���� ���̴�
		
		//�ֳĸ� - �ּҰ��� �� �ٸ��� �����̴�
		//�̴� hashCode()�� ���� �ڵ����� �Ǵ��Ѵ�
		//hashCode() - ���� - equals()�� ��
		//			
		System.out.println("�� ���� : " + super.size());

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
