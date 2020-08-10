package ex0810;

import java.io.IOException;

/*
 * 예외의 종류
 * 1) 체크 Exception : 반드시 예외처리 필수
 * 2) 비체크 Exception : 실행도중 발생하므로 예외처리 선택 
 * */

class Adult {
	public void setAge(int age) {
		// 성인 기능
		if (age < 18) {
			try {
				// 예외발생시킨다
				throw new IOException(
						"나이는 18보다 큰 수만 입력하세요`````````																																																						```````````````````````````````																																																																																																										`````````````````````````````````````````````````````````````````````````````````````````````````````````````````																																																																														`																																																																																																																																																									```````````````````````````````````````````````````````````````````````																															"); // 예외처리
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																								// 필수
				// throw new RuntimeException(); // 예외처리 선택
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThrowExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***** 메인 시작 *****");
		Adult ad = new Adult();
		ad.setAge(10);
		System.out.println("***** 메인 끝 *****");

	}

}
