package ex0811;

import java.util.List;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentService service = new StudentService();

		
/////////////////////////////////////////////////////////////////////////////		
		// 1 . 등록
		System.out.println("***** 등록 *****");
		boolean re = service.insert(new Student("jang", "장희정", 20, "서울"));
		System.out.println("등록결과 : re = " + re);

		re = service.insert(new Student("kim", "장희정", 20, "서울"));
		System.out.println("등록결과 : re = " + re);

		re = service.insert(new Student("king", "장희정", 20, "서울"));
		System.out.println("등록결과 : re = " + re);
		
		System.out.println();
		System.out.println();

		

/////////////////////////////////////////////////////////////////////////////
		// 2 . 전체검색
		System.out.println("***** 전체 검색하기 *****");
		List<Student> list = service.selectAll();
		for (Student st : list) {
			System.out.println(st);
		}

		System.out.println();
		System.out.println();


/////////////////////////////////////////////////////////////////////////////
		// 3 . id에 해당하는 정보 검색
		System.out.println("***** id에 해당하는 정보 검색 *****");
		Student student = service.searchById("kim");
		if (student == null) {
			System.out.println("정보가 없습니다");
		} else {
			System.out.println("student : " + student);
		}
		
		System.out.println();
		System.out.println();

		

/////////////////////////////////////////////////////////////////////////////
		// 4 . id에 해당하는 레코드 삭제
		System.out.println("***** id에 해당하는 레코드 삭제 *****");
		if (service.delete("kima")) {
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("삭제 되지 않았습니다.");
		}

		for (Student st : list) {
			System.out.println(st);
		}

		
		System.out.println();
		System.out.println();


/////////////////////////////////////////////////////////////////////////////
		// 5 . id에 해당하는 정보 수정
		System.out.println("***** id에 해당하는 정보 수정 *****");
		re  = service.update(new Student("kim", 12, "강원도"));
		if (re) {
			System.out.println("수정되었습니다.");
		} else {
			System.out.println("수정 되지 않았습니다.");
		}
		for (Student st : list) {
			System.out.println(st);
		}
		
		
		System.out.println();
		System.out.println();

	}

}
