package ex0812.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExam {

	Map<Integer, String> map = new HashMap<Integer, String>();
	// Map<Integer, String> map = new TreeMap<Integer, String>(); //Ű�� ���ĵ�

	/**
	 * map�� ������ �߰�
	 */
	public void addMap() {
		map.put(10, "���߱�");
		map.put(50, "�����");
		map.put(40, "�赵��");
		map.put(20, "�����");
		map.put(30, "�ڵ���");
		map.put(40, "�ڱ��");
		map.put(70, "������");

	} // put ������ �߰� - ������ ������ ��ü

	/**
	 * map�� �ִ� ������ ������
	 */
	public void printMap() {
		System.out.println("���� : " + map.size());
		System.out.println(map);

		// map�� �ִ� ��� key�� ������ ��������
		Set<Integer> kset = map.keySet();
		Iterator<Integer> it = kset.iterator();
		while (it.hasNext()) {// ���� ��Ұ� �����Ѵٸ�
			Integer key = it.next();
			// key�� �ش��ϴ� value ��������
			String value = map.get(key);
			System.out.println(key + " : " + value);
		}
		System.out.println();
		System.out.println("-----------------------------------");

		System.out.println("------keySet()�� ������ for�� �����غ���------");
		for (Integer key : map.keySet()) {
			String value = map.get(key);
			System.out.println(key + " : " + value);
		}

		Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
		Iterator<Map.Entry<Integer, String>> it2 = entrySet.iterator();
		while (it2.hasNext()) {
			Entry<Integer, String> entry = it2.next();
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " : " + value);

		}
		System.out.println();
		System.out.println("-----entrySet()�� ������ for�� �����غ���------");
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			int key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " : " + value);
		}

	}

	/***
	 * key�� �ش��ϴ� value �˻��ϱ� ������ "key�� �̸��� ~ �Դϴ�." ������ "key�� �������� �ʽ��ϴ�."
	 */
	public void searchByKey(Integer key) {
		System.out.println();
		System.out.println("-----key�� �ش��ϴ� value �˻��ϱ�------");

		if (map.containsKey(key)) {
			String value = map.get(key);
			System.out.println(key + "�� �̸��� " + value + " �Դϴ�.");
		}
		System.out.println("key�� �������� �ʽ��ϴ�.");
		
		/*
		String value = map.get(key);
		if(value == null) {
			System.out.println(key + "�� �������� �ʽ��ϴ�.");
		}else {
			System.out.println(key+"�� �̸��� "+ value+" �Դϴ�.");
		}
		*/

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MapExam me = new MapExam();
		me.addMap();
		me.printMap();
		new MapExam();

		me.searchByKey(1);
		me.searchByKey(10);

	}

}
