/*�����̸�:�����
  ��¥: 20.07.27
  ���� : �޼��� ȣ�� ����  */

  //1.�ΰ��� ������ �����ȣ(+,-,*,/,%) ����
      // �����ȣ �� �̿� ���� �����޽��� ���
  //2.���޵� �����ȣ�� ���� �� �� ����
  //3.���� ��� ��� �޼��� ���� ��

  //4.�� �޼��带 ȣ���ϴ� ���θ޼��带 ������ ��

  //�޼��带 ���� �����
  //ȣ���� �Ѵ�.
class MethodExam{
	//���θ޼���: �̰����� ��ü�� �����ؼ� method01�� ȣ���Ѵ�.
	public static void main(String [] args){
		Calculation cal = new Calculation();
        cal.method01(15, 4, '+');
		cal.method01(15, 4, '-');
		cal.method01(15, 4, '*');
		cal.method01(15, 4, '/');
		cal.method01(15, 4, '%');
		cal.method01(15, 4, '&');
		
	}
}

//�ϴ� �����ȣ ���� ������ ���� �޾ƿ��� �׽�Ʈ
//�����ȣ ���� ��� ��������? �ϴ� String�� ��ü�� �ּҰ��� �����ؼ� == �� �Ұ��ҵ�

class Calculation{
	public  void method01(int a, int b, char c){
		switch(c){
           case '+' : 
             System.out.println(a+" + " + b +" = " + (a+b) ); 
		     break;
		   case '-' : 
             System.out.println(a+" - " + b +" = " + (a-b) ); 
		     break;
           case '*' : 
             System.out.println(a+" * " + b +" = " + (a*b) ); 
		     break;
           case '/' : 
             System.out.println(a+" / " + b +" = " + (a/b) ); 
		     break;
          case '%' : 
             System.out.println(a+" % " + b +" = " + (a%b) ); 
		     break;
          default : System.out.println(c+"�� �߸��� �����ȣ�Դϴ�..");
		}//switch����
		System.out.println("\n");
	}//�޼ҵ峡
}//Ŭ������