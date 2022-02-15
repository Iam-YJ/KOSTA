package ex0819;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class ObjectLoadExam {

	public ObjectLoadExam() {
		//����� ��ü�� �о����
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/ex0819/save.txt"))){
			//���Ͽ� �ִ� ��θ� �о�;��ؼ� fileInputStream
			
			Student st1 = (Student) ois.readObject(); //Student Ÿ���� ������ �ϳ� ������
			Student st2 = (Student) ois.readObject(); 
			List<Student> list = (List<Student>)ois.readObject(); 
			//ĳ���� �ϴ� ������ ������Ʈ Ÿ���̿���
			// �ڽ� �κ��� ���� ������ ĳ���� �ؾ��� 
			
			System.out.println(st1);
			System.out.println(st2);
			System.out.println(list); 
			//�ּҴ� transient �ؼ� �ּҴ� ����ȭ�� ���� �ʾƼ�. ����ȵ� 
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ObjectLoadExam();

	}

}
