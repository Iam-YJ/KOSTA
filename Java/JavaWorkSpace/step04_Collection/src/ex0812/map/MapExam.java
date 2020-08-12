package ex0812.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExam {

	Map<Integer, String> map = new HashMap<Integer, String>();
	// Map<Integer, String> map = new TreeMap<Integer, String>(); //키가 정렬됨

	/**
	 * map에 데이터 추가
	 */
	public void addMap() {
		map.put(10, "송중기");
		map.put(50, "김다정");
		map.put(40, "김도훈");
		map.put(20, "김소은");
		map.put(30, "박동주");
		map.put(40, "박기랑");
		map.put(70, "임지훈");

	} // put 없으면 추가 - 같은게 있으면 교체

	/**
	 * map에 있는 데이터 꺼내기
	 */
	public void printMap() {
		System.out.println("개수 : " + map.size());
		System.out.println(map);

		// map에 있는 모든 key의 정보를 가져오기
		Set<Integer> kset = map.keySet();
		Iterator<Integer> it = kset.iterator();
		while (it.hasNext()) {// 다음 요소가 존재한다면
			Integer key = it.next();
			// key에 해당하는 value 가져오기
			String value = map.get(key);
			System.out.println(key + " : " + value);
		}
		System.out.println();
		System.out.println("-----------------------------------");

		System.out.println("------keySet()을 개선된 for로 변경해보기------");
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
		System.out.println("-----entrySet()을 개선된 for로 변경해보기------");
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			int key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " : " + value);
		}

	}

	/***
	 * key에 해당하는 value 검색하기 있으면 "key의 이름은 ~ 입니다." 없으면 "key는 존재하지 않습니다."
	 */
	public void searchByKey(Integer key) {
		System.out.println();
		System.out.println("-----key에 해당하는 value 검색하기------");

		if (map.containsKey(key)) {
			String value = map.get(key);
			System.out.println(key + "의 이름은 " + value + " 입니다.");
		}
		System.out.println("key는 존재하지 않습니다.");
		
		/*
		String value = map.get(key);
		if(value == null) {
			System.out.println(key + "는 존재하지 않습니다.");
		}else {
			System.out.println(key+"의 이름은 "+ value+" 입니다.");
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
