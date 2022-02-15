package ex0821;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.URL;

public class URLConnectionExam {

	public URLConnectionExam() {

		try {
		/*	URL url = new URL("https://www.daum.net/");
			
			InputStream is = url.openStream(); // 연결한거를 가져오는(읽는) openStream()
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			BufferedWriter bw = new BufferedWriter(new FileWriter("src/ex0821/daum.txt"));
			String data = null;
			while((data=br.readLine())!=null) {//readLine은 읽을것이 없으면 null 반환함 
				System.out.println(data);
				bw.write(data);
				bw.newLine();
			} */ //용량에 차이가 있음. 마지막에 있는 newLine() 때문에
			
			
			/*
			URL url = new URL("https://192.168.0.136/Edu/SW/epp351.exe");
			BufferedInputStream bis = new BufferedInputStream(url.openStream());
			BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("src/ex0821/daum.txt"));
			
			//byte b [] = new byte[bis.available()]; //bis의 길이만큼 
			
			byte b [] = new byte[1024]; //byte 범위가 초과하면(1024) 다운받아지지 않아서 while문으로 계속 돌며 조절
		
			bis.read(b);
			
			while(bis.read()!= -1) {
				bw.write(b);
				bw.flush();
			} */
			//용량에 딱 맞게 하는 코드 + 다운로드 하는 코드
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new URLConnectionExam();

	}

}
