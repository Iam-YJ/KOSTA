package ex0811;

import java.util.ArrayList;
import java.util.List;

class Test {
	int a = 100;

	public void aa() {

	}

	/*
	 * @Override public String toString() { return a; }
	 */

}

class ArrayListExam extends ArrayList {

	// 전역 Variable
	// Object 타입1개, int 타입 1개;
	Object o;
	int i;

	// Constractor
	public ArrayListExam() {
		super(5);
		// ArrayList의 int형 한개 받는 생성자 호출
		// 초기 용량 5개 생성
	}

	// method
	// method이름 리턴타입 인수

	/*
	 * addInt 없음 정수(int)1개 하는일 : 인수로 받은 정수를 객체로 만들어 list에 추가.
	 */
	public void addInt(int i) {
		Integer ii = new Integer(i);
		// int -> Integer 객체로 변환
		super.add(ii);
		// list에 저장한다.
	}

	/*
	 * addFloat 없음 실수(float)1개 하는일 : 인수로 받은 실수를 객체로 만들어 list에 추가.
	 */

	public void addFloat(float f) {
		Float ff = new Float(f);
		this.add(ff);
	}

	/*
	 * addString 없음 String 문자열1개 하는일 : 인수로 받은 String 을 list에 추가.
	 */

	public void addString(String s) {
		super.add(s);
		// String은 원래 객체이다
	}

	/*
	 * printList 없음 없음 정수형 전역변수에 현재 list에 들어있는 객체의 개수 입력한 후(size())전역변수 출력. List에
	 * 저장된 각 객체를 맴버변수에 저장한후 출력
	 */

	public void printList() {
		this.i = this.size();
		System.out.println("저장된 객체의 수 : " + i);

		for (int i = 0; i < this.i; i++) {
			this.o = this.get(i);
			System.out.println("저장된 객체 : " + o);
			// 값이 저장된 것이 아니라 주소가 저장된 것이다.
			// o.toString()이 생략되어 있는 것이다.
		}

		System.out.println("----------");
		this.o = super.get(2); // Test 객체
		// o.a; //부모타입으로 자식부분 접근 불가

		System.out.println("obj 주소 : " + o);
		if (o instanceof Test) {
			Test t = (Test) o;
			System.out.println("t 주소 : " + t);
			System.out.println(t.a);
		}
		
		System.out.println("-------개선된 for-----");
		for(Object o : this) { 
			//this는 상속을 받았기 때문에 사용할 수 있음
			//내가 곧 List 이기 때문에
			System.out.println(o);
		}
	}

	public static void main(String args[]) {
		ArrayListExam list = new ArrayListExam();
		String s = new String("newString");
		list.addInt(5);
		list.addFloat(5.5F);
		list.addString(s);
		list.printList();
	}
}

//Integer it2 = 10; //오토박싱
//int a = new Integer(5); //언박싱



/*
 * 실행결과
 * 
 * list에 들어있는 객체의 총 개수는=3 5 5.5 newString
 * 
 * Normal Termination 출력 완료 (0초 경과).
 */