package ex0819;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectSaveExam {

	public ObjectSaveExam() {
		// ����ȭ�ؼ� ������ ��ü�� �غ�
		Student st1 = new Student("����", 20, "����");
		Student st2 = new Student("����", 22, "�뱸");

		List<Student> list = new ArrayList<Student>();
		list.add(new Student("ȿ��", 25, "���ֵ�"));
		list.add(new Student("��", 27, "����"));
		list.add(new Student("�缮", 23, "�λ�"));

		// ����

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/ex0819/save.txt"))) {

			oos.writeObject(st1);
			oos.writeObject(st2);
			oos.writeObject(list);

			System.out.println("***** ���� ���� �Ϸ� *****");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ObjectSaveExam();

	}

}
