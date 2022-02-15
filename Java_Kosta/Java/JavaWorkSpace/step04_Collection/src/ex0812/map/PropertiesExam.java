package ex0812.map;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.spi.ResourceBundleControlProvider;

public class PropertiesExam {

	Properties pro = new Properties();

	public PropertiesExam() {
		// 저장
		pro.setProperty("id", "jang");
		pro.setProperty("age", "20");
		pro.setProperty("addr", "경기도 판교");

		// 꺼내기
		Set<String> keys = pro.stringPropertyNames(); // 모든 key 정보 set으로 가져오기
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = pro.getProperty(key);
			System.out.println(key + " : " + value);
		}
	}

	/**
	 * 외부 ~.properties 파일 로딩 1) IO를 이용해서 properties 파일을 로딩 2) ResourceBundle 객체를 이용한
	 * 로딩
	 */

	// 1) IO를 이용해서 properties 파일을 로딩
	public void test1() throws Exception {
		pro.clear(); // 비워라

		pro.load(new FileInputStream("src/ex0812/map/test.properties"));

		// 꺼내기
		Set<String> keys = pro.stringPropertyNames(); // 모든 key 정보 set으로 가져오기
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = pro.getProperty(key);
			System.out.println(key + " : " + value);
		}

	}

	// 2) ResourceBundle 객체를 이용한 로딩
	// ResourceBundle객체는 ~.properties 파일 로딩하는 전용 클래스
	// 경로를 지정할 때 확장자는 생략한다.
	// 기준 폴더가 classes 폴더이다
	public void test2() {
		ResourceBundle rb = ResourceBundle.getBundle("ex0812/map/test");

		Set<String> keys = rb.keySet();
		Iterator<String> it = keys.iterator();

		while (it.hasNext()) {
			String key = it.next();
			String value = rb.getString(key);
			System.out.println(key + " : " + value);
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		PropertiesExam pe = new PropertiesExam(); // 생성자에서 찍힌거 나옴
		System.out.println("---------------------");
		// pe.test1();
		pe.test2();

	}

}
