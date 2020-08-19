package ex0819;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectSaveExam {

	public ObjectSaveExam() {
		// 직렬화해서 저장할 객체를 준비
		Student st1 = new Student("희정", 20, "서울");
		Student st2 = new Student("나영", 22, "대구");

		List<Student> list = new ArrayList<Student>();
		list.add(new Student("효리", 25, "제주도"));
		list.add(new Student("비", 27, "서울"));
		list.add(new Student("재석", 23, "부산"));

		// 저장

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/ex0819/save.txt"))) {

			oos.writeObject(st1);
			oos.writeObject(st2);
			oos.writeObject(list);

			System.out.println("***** 파일 저장 완료 *****");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ObjectSaveExam();

	}

}
