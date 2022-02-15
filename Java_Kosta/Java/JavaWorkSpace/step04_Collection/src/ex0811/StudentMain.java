package ex0811;

import java.util.List;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentService service = new StudentService();

		
/////////////////////////////////////////////////////////////////////////////		
		// 1 . ���
		System.out.println("***** ��� *****");
		boolean re = service.insert(new Student("jang", "������", 20, "����"));
		System.out.println("��ϰ�� : re = " + re);

		re = service.insert(new Student("kim", "������", 20, "����"));
		System.out.println("��ϰ�� : re = " + re);

		re = service.insert(new Student("king", "������", 20, "����"));
		System.out.println("��ϰ�� : re = " + re);
		
		System.out.println();
		System.out.println();

		

/////////////////////////////////////////////////////////////////////////////
		// 2 . ��ü�˻�
		System.out.println("***** ��ü �˻��ϱ� *****");
		List<Student> list = service.selectAll();
		for (Student st : list) {
			System.out.println(st);
		}

		System.out.println();
		System.out.println();


/////////////////////////////////////////////////////////////////////////////
		// 3 . id�� �ش��ϴ� ���� �˻�
		System.out.println("***** id�� �ش��ϴ� ���� �˻� *****");
		Student student = service.searchById("kim");
		if (student == null) {
			System.out.println("������ �����ϴ�");
		} else {
			System.out.println("student : " + student);
		}
		
		System.out.println();
		System.out.println();

		

/////////////////////////////////////////////////////////////////////////////
		// 4 . id�� �ش��ϴ� ���ڵ� ����
		System.out.println("***** id�� �ش��ϴ� ���ڵ� ���� *****");
		if (service.delete("kima")) {
			System.out.println("�����Ǿ����ϴ�.");
		} else {
			System.out.println("���� ���� �ʾҽ��ϴ�.");
		}

		for (Student st : list) {
			System.out.println(st);
		}

		
		System.out.println();
		System.out.println();


/////////////////////////////////////////////////////////////////////////////
		// 5 . id�� �ش��ϴ� ���� ����
		System.out.println("***** id�� �ش��ϴ� ���� ���� *****");
		re  = service.update(new Student("kim", 12, "������"));
		if (re) {
			System.out.println("�����Ǿ����ϴ�.");
		} else {
			System.out.println("���� ���� �ʾҽ��ϴ�.");
		}
		for (Student st : list) {
			System.out.println(st);
		}
		
		
		System.out.println();
		System.out.println();

	}

}
