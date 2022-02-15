package ex0811;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

	private List<Student> list = new ArrayList<Student>();
	// �������̽� Ÿ��
	// �����ڴ� �������̽��� call�ϸ� ���⼭�� ���� ���� ��ü�� call �Ѵ�

	public StudentService() {
		list.add(new Student("aa", "�ϳ���", 10, "����"));
		list.add(new Student("bb", "�̳���", 20, "����"));
		list.add(new Student("cc", "�ﳪ��", 30, "����"));
		list.add(new Student("dd", "�糪��", 40, "����"));
		list.add(new Student("ee", "������", 50, "����"));

	}

	/**
	 * �߰� (�л� ���)
	 * 
	 * @return : true�̸� ��ϼ��� ,, false�̸� ��Ͻ���
	 */

	public boolean insert(Student student) {
		// �߰����� id �ߺ����� üũ�ϰ� �ߺ��ƴϸ� �߰��Ѵ�.
		if (this.searchById(student.getId()) != null) {
			return false;
		}
		boolean result = list.add(student);

		return result;
	}

	/**
	 * ��ü�˻�
	 */
	public List selectAll() {
		return list;
	}

	/**
	 * id�� �ش��ϴ� �л����� �˻�
	 */

	public Student searchById(String id) {
		/*
		 * for (int i = 0; i < list.size(); i++) { Student st = list.get(i); if
		 * (st.getId().equals(id)) { return st; } }
		 */

		// ������ for
		for (Student st : list) {
			if (st.getId().equals(id)) {
				return st;
			}
		}
		return null;
	}

	/**
	 * id�� �ش��ϴ� �л� ����
	 * 
	 * @return : true �̸� ���� ����, fasle�̸� ���� ����
	 */

	public boolean delete(String id) {
		Student st = this.searchById(id);

		return list.remove(st);

		// remove�� boolean���� �ǵ����ش�
	}

	/**
	 * id�� �ش��ϴ� �л��� ���̿� �ּ� ����
	 * 
	 * @return : true�̸� ��������, false�̸� ��������
	 */

	public boolean update(Student student) { // id, age, addr
		Student searchStudent = this.searchById(student.getId());

		if (searchStudent == null) {
			return false;
		} else {
			searchStudent.setAddr(student.getAddr());
			searchStudent.setAge(student.getAge());

			return true;
		}

	}

}
