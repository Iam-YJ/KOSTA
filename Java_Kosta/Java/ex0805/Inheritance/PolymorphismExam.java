class CarCenter{
	public void engineer(Car cd){ //�Ű������� �̿��� ������ 
		//Car(�θ�) Ÿ������ �޾Ƽ� �ڽĵ鿡 ������ �� ����
		//������ �ڽ� �� car Ÿ�Ը� ���� �����ϰ� �ڽ� Ÿ���� ���� x 
		System.out.print(cd.carname+" �����Ϸ�!\t");
		System.out.println("û�����"+cd.cost+" ��");
		
	}
}

public class PolymorphismExam{ // InferitanceExam.java�� ���� Ŭ������ �־���Ѵ�.
	public static void main(String[] args) {
		
		CarCenter cc=new CarCenter();
		EfSonata ef=new EfSonata(); //ef�� car��� �θ� �� �ֱ� ������ engineer������ ���� x
		Canival ca=new Canival();
		Excel ex=new Excel();
		Car c= new Car();
		
	sdd	cc.engineer(c);//
		cc.engineer(ef);//
		cc.engineer(ca);//
		
		/*
		System.out.println("ex �ּ� : " + ex);
		System.out.println("ex.a : "  + ex.a);
		
		
		System.out.println("cd.a : "  + cd.a); 
		//�θ�Ÿ�� �����δ� �ڽĺκ� ������ �� ����
		// -> ���ٰ����ϰ� �Ϸ��� �θ�Ÿ�Ժ����� �ڽ�Ÿ�Ժ����� ��´�
		// -> �θ� > �ڽ� : �׷��� ObjectDownCasting �ʿ��ϴ� 
		//Excel e = (Excel) cd; ->ObjectDownCasting
		// -->> System.out.println("e.a : "  + e.a); 
*/
		cc.engineer(ex);//
		
		
	
	}
}
