package ex0812.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetExam {
	
	Set<String> set = new HashSet<String>();
	
	//Set<String> set = new TreeSet<String>();
	//TreeSet�� ������ �Ǿ ���´� (�� �� ������δ� �ƴ�)
	
	/**
	 * set�� ������ �߰��ϱ�
	 * */
	public void addSet(String [] args) {
		for(String s : args) {
			boolean result = set.add(s);
			System.out.print(s + " �߰���� " + result);
			System.out.println();
			
		}System.out.println();
		System.out.println("���� : "+set.size());
	}
	
	/**
	 * set�� �ִ� ������ ����ϱ�
	 * */
	public void printSet() {
		System.out.println("************");
		System.out.println(set);
		System.out.println();
		//set�� ������ ��� ���� ������� ������ ���� 
		//set�� ������ ������� �� ���� 
		
		//set�� �ִ� �����͸� �ݺ���(Iterator)�� �̿��ؼ� ��������
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) { //������Ұ� �����Ѵٸ�(boolean�� ��ȯ)
			String s = it.next(); //������Ҹ� ������(��ü�� ��ȯ)
			System.out.println(s);
		}
		
		System.out.println("------------������ for ----------------");
		for(String s : set) {
			System.out.println(s);
		}
		
		/*
		//�������� ����
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
