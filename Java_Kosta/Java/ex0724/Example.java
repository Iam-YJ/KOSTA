class Example{

 public static void main(String [] args){

	int random = (int)(Math.random() * 10 + 1);
	//1 �Ͽ���
	int day = random % 7;
	String days = "��";

	switch(day){
		case 1 :
			days = "��";
			break;
		case 2 : 
			days = "��";
			break;
		case 3 : 
			days = "ȭ";
			break;
		case 4 : 
			days = "��";
			break;
		case 5 : 
			days = "��";
			break;
		case 6 : 
			days = "��";
			break;
	}
	System.out.println(day+"�� "+days+"���� �Դϴ�."); 
 }


}