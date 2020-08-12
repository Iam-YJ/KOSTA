package ex0812.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetExam {
	
	Set<String> set = new HashSet<String>();
	
	//Set<String> set = new TreeSet<String>();
	//TreeSet은 정렬이 되어서 나온다 (단 들어간 순서대로는 아님)
	
	/**
	 * set에 데이터 추가하기
	 * */
	public void addSet(String [] args) {
		for(String s : args) {
			boolean result = set.add(s);
			System.out.print(s + " 추가결과 " + result);
			System.out.println();
			
		}System.out.println();
		System.out.println("개수 : "+set.size());
	}
	
	/**
	 * set에 있는 데이터 출력하기
	 * */
	public void printSet() {
		System.out.println("************");
		System.out.println(set);
		System.out.println();
		//set은 순서가 없어서 넣은 순서대로 나오지 않음 
		//set은 순서를 보장받을 수 없다 
		
		//set에 있는 데이터를 반복자(Iterator)를 이용해서 가져오기
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) { //다음요소가 존재한다면(boolean형 반환)
			String s = it.next(); //다음요소를 꺼내라(객체형 반환)
			System.out.println(s);
		}
		
		System.out.println("------------개선된 for ----------------");
		for(String s : set) {
			System.out.println(s);
		}
		
		/*
		//내림차순 정렬
		TreeSet<String> treeSet = (TreeSet<String>)set;
		Iterator <String> it2 = treeSet.descendingIterator();
		*/
	}
	
	public static void main(String [] args) {
		SetExam se = new SetExam();
		se.addSet(args);
		se.printSet();
		
	}
}
