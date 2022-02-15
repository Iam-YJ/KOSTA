package ex0813.map;

import java.util.Map;

public class MapStudentController {

	private static MapStudentService service = new MapStudentService();

	// ���� �⺻�����ڰ� �⺻���� �ֱ� ������ �ϴ��� ������ ���� ������ �ȸ��� ��

	/**
	 * ��ü�˻�
	 */
	public static void selectAll() {
		// service�� ȣ���ϰ� �� ����� �޾Ƽ� EndView ȣ���Ѵ�.
		try {
			Map<String, Person> map = service.selectAll();

			EndView.printAll(map); // ������ ���� ������ �̰Ÿ� �о�
		} catch (Exception e) {// ���ʿ��� ����ó���� ������.. ȣ���� �̰����� ó�����־���Ѵ�
			// ���ܰ� �߻����� �� �ؾ����� �ۼ�
			EndView.printMessage(e.getMessage());

		}

	}

	/**
	 * id�� �ش��ϴ� ���� �˻��ϱ�
	 */
	public static void searchById(String id) {

		try {
			Person person = service.searchByKey(id);
			EndView.printSearch(person);
			System.out.println("��ϵǾ����ϴ�.");
		} catch (Exception e) {
			EndView.printMessage(e.getMessage());
		}
	}

	/**
	 * ����ϱ�
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
	 * key�� �ش��ϴ� ������ ã�Ƽ� ����
	 */
	public static void delete(String id) { // key�� id �̴�
		try {
			service.delete(id);
			EndView.printMessage("���� �Ǿ����ϴ�.");
			System.out.println();
		} catch (Exception e) {
			EndView.printMessage(e.getMessage());
		}
	}

	/**
	 * �����ϱ�
	 * 
	 * @param : Person or Student
	 */
	public static void update(Person person) {
		try {
			service.update(person);
			EndView.printMessage("�����Ǿ����ϴ�.");
			System.out.println();
		} catch (Exception e) {
			EndView.printMessage(e.getMessage());
		}

	}

}
