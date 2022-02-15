package ex0819;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class ObjectLoadExam {

	public ObjectLoadExam() {
		//저장된 객체를 읽어오기
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/ex0819/save.txt"))){
			//파일에 있는 경로를 읽어와야해서 fileInputStream
			
			Student st1 = (Student) ois.readObject(); //Student 타입의 정보를 하나 가져옴
			Student st2 = (Student) ois.readObject(); 
			List<Student> list = (List<Student>)ois.readObject(); 
			//캐스팅 하는 이유는 오브젝트 타입이여서
			// 자식 부분의 것을 보려면 캐스팅 해야함 
			
			System.out.println(st1);
			System.out.println(st2);
			System.out.println(list); 
			//주소는 transient 해서 주소는 직렬화가 되지 않아서. 저장안됨 
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ObjectLoadExam();

	}

}
