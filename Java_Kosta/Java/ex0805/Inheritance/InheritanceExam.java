
class Car{
		public String carname;
		public int cost;
		
		protected void printAttributes(){
			System.out.println("carname="+carname+"\tcost="+cost);
		}
}

//Car�� ��ӹ޴� EfSonata, Excel, Carnival 3�� Ŭ���� �ۼ�	
	//�� Ŭ������ �μ��� �����ʴ� ������ �ۼ�
	//�� Ŭ������ �������� �����ο��� carname�� cost�� ������ �� �Ҵ�
	class EfSonata extends Car{
		EfSonata(){
			this.carname = "�ҳ�Ÿ";
			this.cost = 1000;
		}
	}
//ObjectDownCasting�� �ϱ� ���� inststanceof�� �̿��Ͽ� ����ȯ ���������� üũ�� �� ĳ������ �Ѵ�.
	class Excel extends Car{
		Excel(){
			int a = 5;
			su��2is.cost = 2000;
		}
	}

	class Canival extends Car{
		Canival(){
			this.carname = "ī�Ϲ�";
			this.cost = 3000;
		}
	}

	
public class InheritanceExam{
	//���θ޼ҵ忡�� 
	public static void main(String [] args){
		Car c = new Car();
		EfSonata efs = new EfSonata();
		Excel ex = new Excel();
		Canival cv = new Canival();

		c.printAttributes();
		efs.printAttributes();
		ex.printAttributes();
		cv.printAttributes();
 // ������ ��ü�� ��ӹ޾Ƶ� �θ�� ���� �����ȴ�.

		
	}
	
		//Car, EfSonata, Excel, Canival �װ��� ��ü�� ����
		// �� Ŭ�������� Car calss���ִ� printAttributes()�޼ҵ带 ȣ���Ҽ��ִ�.
		
	
}

