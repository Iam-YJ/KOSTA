package ex0811;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

	private List<Student> list = new ArrayList<Student>();
	// 인터페이스 타입
	// 개발자는 인터페이스를 call하면 여기서는 실제 구현 객체를 call 한다

	public StudentService() {
		list.add(new Student("aa", "일나영", 10, "제주"));
		list.add(new Student("bb", "이나영", 20, "제주"));
		list.add(new Student("cc", "삼나영", 30, "제주"));
		list.add(new Student("dd", "사나영", 40, "제주"));
		list.add(new Student("ee", "오나영", 50, "제주"));

	}

	/**
	 * 추가 (학생 등록)
	 * 
	 * @return : true이면 등록성공 ,, false이면 등록실패
	 */

	public boolean insert(Student student) {
		// 추가전에 id 중복여부 체크하고 중복아니면 추가한다.
		if (this.searchById(student.getId()) != null) {
			return false;
		}
		boolean result = list.add(student);

		return result;
	}

	/**
	 * 전체검색
	 */
	public List selectAll() {
		return list;
	}

	/**
	 * id에 해당하는 학생정보 검색
	 */

	public Student searchById(String id) {
		/*
		 * for (int i = 0; i < list.size(); i++) { Student st = list.get(i); if
		 * (st.getId().equals(id)) { return st; } }
		 */

		// 개선된 for
		for (Student st : list) {
			if (st.getId().equals(id)) {
				return st;
			}
		}
		return null;
	}

	/**
	 * id에 해당하는 학생 삭제
	 * 
	 * @return : true 이면 삭제 성공, fasle이면 삭제 실패
	 */

	public boolean delete(String id) {
		Student st = this.searchById(id);

		return list.remove(st);

		// remove는 boolean형을 되돌려준다
	}

	/**
	 * id에 해당하는 학생의 나이와 주소 변경
	 * 
	 * @return : true이면 수정성공, false이면 수정실패
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
