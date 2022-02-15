package ex0813.map;

import java.util.Map;

public class MapStudentController {

	private static MapStudentService service = new MapStudentService();

	// 원래 기본생성자가 기본으로 있기 때문에 하는일 없으면 굳이 생성자 안만들어도 됨

	/**
	 * 전체검색
	 */
	public static void selectAll() {
		// service를 호출하고 그 결과를 받아서 EndView 호출한다.
		try {
			Map<String, Person> map = service.selectAll();

			EndView.printAll(map); // 오류가 나지 않으면 이거를 읽어
		} catch (Exception e) {// 저쪽에서 예외처리를 던져서.. 호출한 이곳에서 처리해주어야한다
			// 예외가 발생했을 때 해야할일 작성
			EndView.printMessage(e.getMessage());

		}

	}

	/**
	 * id에 해당하는 정보 검색하기
	 */
	public static void searchById(String id) {

		try {
			Person person = service.searchByKey(id);
			EndView.printSearch(person);
			System.out.println("등록되었습니다.");
		} catch (Exception e) {
			EndView.printMessage(e.getMessage());
		}
	}

	/**
	 * 등록하기
	 * 
	 * @param : Student or Person
	 */
	public static void insert(Person person) {
		try {
			service.insert(person);
		} catch (Exception e) {
			EndView.printMessage(e.getMessage());
		}
		System.out.println();
	}

	/**
	 * key에 해당하는 정보를 찾아서 삭제
	 */
	public static void delete(String id) { // key는 id 이다
		try {
			service.delete(id);
			EndView.printMessage("삭제 되었습니다.");
			System.out.println();
		} catch (Exception e) {
			EndView.printMessage(e.getMessage());
		}
	}

	/**
	 * 수정하기
	 * 
	 * @param : Person or Student
	 */
	public static void update(Person person) {
		try {
			service.update(person);
			EndView.printMessage("수정되었습니다.");
			System.out.println();
		} catch (Exception e) {
			EndView.printMessage(e.getMessage());
		}

	}

}
