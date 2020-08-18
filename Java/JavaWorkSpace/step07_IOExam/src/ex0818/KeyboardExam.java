package ex0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KeyboardExam {

	public KeyboardExam() throws Exception {
		// 키보드 입력
/*		InputStream is = System.in;
		int i = is.read(); // 한바이트 읽기
		System.out.println(i + " = " + (char) i); */
		
		//byte 단위 처리를 문자단위 변경 
		/* InputStreamReader isr = new InputStreamReader(System.in); //inputStream은 보조 스트림임. 
		int i = isr.read(); // 한바이트 읽기
		System.out.println(i + " = " + (char) i); */
		
		//Buffered를 이용해서 한줄읽기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("입력 : ");
		String data = br.readLine();
		System.out.println("출력 : "+data);
		

	}

	public static void main(String[] args) throws Exception {
		new KeyboardExam();

	}

}
