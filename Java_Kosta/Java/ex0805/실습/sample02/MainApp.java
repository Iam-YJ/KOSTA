
public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee e = new Employee();
		FullTime f = new FullTime();
		PartTime p = new PartTime();
		
		Employee [] eArr = new Employee [5];
		FullTime [] full = {
			new FullTime (10, "���缮", "���׿��", 0 , "2013-05-01", "���ѵ���",8500,200),
			new FullTime (20, "�ڸ��", "����",10, "2013-06-20", "���ѵ���",7500,100),
			new FullTime (30, "������", "������",10 , "2013-06-22", "���ѵ���",6000,0)
		};
		
		PartTime [] part = {
				new PartTime(40, "��ȫö", "������",20 , "2014-05-01", "���ѵ���",20000),
				new PartTime(50, "����", "����",30 , "2014-05-02", "���ѵ���",25000)
		};
		
		
		for(int i=0; i<full.length; i++) {
			eArr[i] = full[i];
		}
		
		for(int i=0; i<part.length; i++) {
			eArr[i+3] = part[i];
		}
		
		
		
		System.out.println("********** Emp ���� **********");
		for(int i=0; i<eArr.length; i++){
			System.out.println(eArr[i]);
			//System.out.println(eArr[i].toString());
			//�θ��ʿ� �־ �����ǵ� �޼ҵ�� �ڽĲ��� ���´�
		}
		System.out.println();
		
		

		System.out.println("********** Emp Message ���� **********");
		for(int i=0; i<eArr.length; i++){
			eArr[i].message();
			System.out.println();
		}
		System.out.println();
	
		
		

		

	}

}






