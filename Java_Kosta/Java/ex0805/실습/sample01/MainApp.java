
public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FullTime ft = new FullTime();
		PartTime pt = new PartTime();
		
		FullTime [] full = new FullTime[3];
		PartTime [] part = new PartTime[2];

		full[0] = new FullTime(10, "���缮", "���׿��", 0 , "2013-05-01", "���ѵ���",8500,200);
		full[1] = new FullTime(20, "�ڸ��", "����",10, "2013-06-20", "���ѵ���",7500,100);
		full[2] = new FullTime(30, "������", "������",10 , "2013-06-22", "���ѵ���",6000,0);
		
		part[0] = new PartTime(40, "��ȫö", "������",20 , "2014-05-01", "���ѵ���",20000);
		part[1] = new PartTime(50, "����", "����",30 , "2014-05-02", "���ѵ���",25000);
		
		//���ȭ���� ���� �ڵ��ϱ� ...
		//���ȭ��ó�� �ڵ��ϱ� 

		System.out.println("********** FullTime ���� **********");
		for(int i=0; i<full.length; i++){
			System.out.println(full[i]);
			//System.out.println(full[i].toString());
		}
		System.out.println();

		/* ������ for
		for(FullTime f : full){
			System.out.println(f);
		}
			
		*/

		System.out.println("********** PartTime ���� **********");
		for(int i=0; i<part.length; i++){
			System.out.println(part[i]);
		}System.out.println();



	
		ft.message(full);
		pt.message(part);
		System.out.println();
	

		/*
		for(int i=0; i<full.length; i++){
			full[i].message();
		} //�� message()�� �Ķ���͸� ���־� �۵� 
		*/
		
		

		

	}

}






