//ObjectInArray.java

class ObjectOne{
	public int a;
}

public class ObjectInArray{
	//���� �޼ҵ忡�� 
	public static void main(String [] args){
		ObjectOne oo = new ObjectOne();

		ObjectOne [] arr = new ObjectOne[5];

		for(int i=0; i<arr.length; i++){
			arr[i] = new ObjectOne();
		}

		for(int i=0; i<arr.length; i++){
			System.out.println("arr["+i+"]�� �������� "+arr[i].a);
			System.out.println("arr["+i+"]�� �ּҰ� "+ arr[i]);
			System.out.println();
		}

		for(int i=0; i<arr.length; i++){
			int num = (int)(Math.random()*50+1);
			arr[i].a = num;
			System.out.println("����� arr["+i+"]�� �������� "+arr[i].a);
			System.out.println();
		}
	}
	
		//ObjectOne Ÿ���� 5�� ���� �����ϴ� �迭�� �����ϰ�
		 
		//5���� ObjectOne��ü�� �����ϼ���.
		//�� ��ü�� �����ִ� �������� ���
		//�� ��ü�� �ּҰ� ���
			
		//������ ObjectOne��ü�� ���� �ٸ� a�� ���� ������ a�� ���� �����ϼ���.			
		//�� ObjectOne ��ü�� a�� ����ϼ���
}
