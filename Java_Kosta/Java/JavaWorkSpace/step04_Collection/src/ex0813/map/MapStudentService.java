package ex0813.map;

import java.util.Map;
import java.util.TreeMap;

import javax.management.RuntimeErrorException;

public class MapStudentService {

	Person person = new Person();

	private Map<String, Person> map = new TreeMap<String, Person>();
	// String id�� key�̰�, Person Ÿ���� value��.
	// key ���� ������ �� �ִ� TreeMap�� �̿��� ���̴�

	/**
	 * map�� Person or Student�� �����ؼ� �����Ѵ�(�ʱ�ġ ������ ����)
	 */
	public MapStudentService() {
		map.put("jang", this.create("jang", "������", 20)); // Person
		map.put("kim", this.create("kim", "����", 25));
		map.put("girl", this.create("girl", "��ҿ�", 30));

		map.put("king", this.create("king", "���߱�", 28, 80, 90, 85)); // Student
		map.put("queen", this.create("queen", "������", 20, 90, 70, 95)); // Student
		map.put("lee", this.create("lee", "��ȿ��", 33, 90, 60, 75)); // Student

	}

	/**
	 * ó�� �ʱ�ġ������ ������ ���� ��ü�� �����ؼ� �������ִ� �޼ҵ�
	 * 
	 * @return : Person or Student �̱� ������ Person����..
	 */

	public Person create(String id, String name, int age, int... param) {
		// int...param �� �Ű������� ������ �޴� �� (���� ����)
		// Person�� ��(������ ���� ��), student�� ��(������ ���� ��) ��� Ŀ�� ����

		if (param.length == 0) {// param�� �ȵ����� person
			return new Person(id, name, age);
		} else { // param�� ������ student
			return new Student(id, name, age, param[0], param[1], param[2]);
		}

	}

	/**
	 * ��ü�˻��ϱ�
	 */

	public Map<String, Person> selectAll() throws Exception {
		if (!map.isEmpty()) {
			return map;
		} else {
			// throw new RuntimeException("�˻��� ������ �����ϴ�"); //��üũ - ����ó�� ���� �����൵ ��
			throw new Exception("�˻��� ������ �����ϴ�."); // üũ - ����ó�� ���� �� ����ߵ�
		}
	}

	/**
	 * key(�л� id)�� �ش��ϴ� ���� �˻� :key�ش��ϴ� ������ ����Ҷ� [ Person�ΰ��� �̸��� ��� Student�ΰ��� �̸���
	 * ���� ��� ] -> EndView���� ���°��� "id�� �����ϴ�." ���ܹ߻�
	 */
	public Person searchByKey(String key) throws Exception {
		// student�ϼ��� �ְ� person�ϼ��� �ֱ� ������
		// �ΰ��� ��� ���� ������ Person����

		Person person = map.get(key);
		if (person == null) {
			throw new Exception(key + "�� �ش��ϴ� ������ �����ϴ�.");
		}
		return person;
	}

	/**
	 * ��� : key�� Person�� ������ �޾� ����ϴ� �޼ҵ� ����� �����ϸ�(id�ߺ�üũ!!) ���ܹ߻���Ų��. - throw new
	 * XxxException("key�� �ߺ��Դϴ�") ("��ϵ��� �ʾҽ��ϴ�.") :����ó���� ������ �� ���̴� (�ֳĸ� ���ܰ� �߻��ϸ� ���߱�
	 * ������ ������ ���α׷��� �����ϵ���) ...�޼ҵ� ����� ���� throws XxxException{}
	 */
	public void insert(Person person) throws Exception {// Student or Person

		if (map.containsKey(person.getId())) {
			throw new Exception(person.getId() + "�� �ߺ��̹Ƿ� ����� �� �����ϴ�.");

		} else {
			map.put(person.getId(), person);
		}
	}

	/**
	 * ���� : id�� �ش��ϴ� value�� �������� ������ ���ܹ߻� (�������� �ʾҽ��ϴ�.)
	 */
	public void delete(String id) throws Exception {
		// remove �޼ҵ��� ���ϰ��� ������ �Ǹ� ������ ��ü�� ����,
		// �������� ������ null�� ����
		Person person = map.remove(id);
		if (person == null) {
			throw new Exception(id + "�� �ش��ϴ� ������ ���� ������ �� �����ϴ�.");

		}

	}

	/**
	 * ���� ����, Person�ΰ�� - �̸��� ���� Student�ΰ�� - �̸�, ���� ,����,���м���(���� ����)
	 * 
	 * ������ �ȵȴٸ� ���ܹ߻�
	 * 
	 */
	public void update(Person person) throws Exception {
		Person savePerson = map.get(person.getId());

		if (savePerson == null) {
			throw new Exception(person.getId() + "�� �߸��Ǿ� ������ �� �����ϴ�.");

		}

		if (person instanceof Student) {
			if (savePerson instanceof Student) {
				savePerson.setName(person.getName());

				Student dataStudent = (Student) person;
				Student updateStudent = (Student) savePerson;

				updateStudent.setKor(dataStudent.getKor());
				updateStudent.setEng(dataStudent.getEng());
				updateStudent.setMath(dataStudent.getMath());

				int sum = updateStudent.getKor() + updateStudent.getEng() + updateStudent.getMath();

			} else {
				throw new Exception("Ÿ�� ������ ������ �� �����ϴ�.");
			}
		} else {
			savePerson.setName(person.getName());
		}
	}

}
