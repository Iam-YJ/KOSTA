class RandomQuiz2{
	public static void main(String args[]){
	//1~12������ ������ �߻�
	int month = (int)(Math.random()*12)+1;

	//���ڿ� ���� �� ���� ��ĥ���� �ִ��� ���ϱ�
	//������ ������� �ʴ´�.
	//��³���: X���� YY�ϱ����Դϴ�. ���
	//1 3 5 7/ 8 10 12�� 31�ϱ��� =>month�� 9���� �۰� Ȧ���̰ų�(1,3,5,7) 8���� ũ�ų� �����鼭 ¦��(8,10,12)
	//4 6 9 11�� 30�ϱ���=>month�� 2����ũ�� 8���������� ¦���̰ų�(4,6) 8���� ũ�鼭 Ȧ��(9,11)
	//2�� 28�ϱ���=>�� ��
	if(month == 2){
		System.out.println(month+"���� 28�ϱ����Դϴ�.");
	}else if(month<9 && month %2!=0){
		System.out.println(month+"���� 31�ϱ����Դϴ�.");
	}else if(month>=8 && month%2==0){
		System.out.println(month+"���� 31�ϱ����Դϴ�.");
	}else if(month>2 && month <8){
		if(month%2==0){
		System.out.println(month+"���� 30�ϱ����Դϴ�.");
		}
	}
	else if(month >8 &&month %2!=0){
		System.out.println(month+"���� 30�ϱ����Դϴ�.");
	}

	}
 }
