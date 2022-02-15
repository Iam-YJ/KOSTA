package ex0813.map;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class EndView {

	/**
	 * ��ü��� (�� �ȿ� ���)
	 */
	public static void printAll(Map<String, Person> map) {
		System.out.println("***** Map ���� LIST ***** " + map.size() + "�� *****");

		Set<String> kset = map.keySet(); //��� key�� ���� ��������
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
	 * key�� �ش��ϴ� ���� ��� [Person�� ���� �̸��� ��� 
	 * Student�� ���� �̸��� ���� ��� ]
	 */
	public static void printSearch(Person person) {
		
		System.out.println("�̸� : "+person.getName());
		
		if (person instanceof Student) {
			Student student = (Student)person;
			System.out.println(" ���� : "+student.getSum());
		}   System.out.println();

	}

	/**
	 * ���� or ���� �޼��� ���
	 */
	public static void printMessage(String message) {
		System.out.println(message);
		System.out.println();

	}

}
