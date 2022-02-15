package ex0813.map;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class EndView {

	/**
	 * 전체출력 (맵 안에 모두)
	 */
	public static void printAll(Map<String, Person> map) {
		System.out.println("***** Map 정보 LIST ***** " + map.size() + "명 *****");

		Set<String> kset = map.keySet(); //모든 key의 정보 가져오기
		Iterator<String> it = kset.iterator();
		
		while(it.hasNext()) {
			String key = it.next();
			Person p = map.get(key);
			System.out.println(p);
		}  System.out.println();
		
//		for (Entry<String, Person> e : map.entrySet()) {
//			System.out.println(e.get);
//		}

	}

	/**
	 * key에 해당하는 정보 출력 [Person인 경우는 이름만 출력 
	 * Student인 경우는 이름과 총점 출력 ]
	 */
	public static void printSearch(Person person) {
		
		System.out.println("이름 : "+person.getName());
		
		if (person instanceof Student) {
			Student student = (Student)person;
			System.out.println(" 총점 : "+student.getSum());
		}   System.out.println();

	}

	/**
	 * 성공 or 실패 메세지 출력
	 */
	public static void printMessage(String message) {
		System.out.println(message);
		System.out.println();

	}

}
