import java.util.Scanner; 

class Symbol{
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		

		System.out.println("������ �Է��ϼ��� : ");
		int a = scan.nextInt();
		System.out.println("������ �Է��ϼ��� : ");
		int b = scan.nextInt();
		System.out.println("�����ȣ�� �Է��ϼ���(+,-,*,/,%) : ");
		String s = scan.next();

		Symbol sym = new Symbol();
		int result = sym.Cal(a,b,s);
		System.out.println(result);

	}

	public int Cal(int a, int b, String s){
		int sum = 0;
			switch(s){
				case "+" :
					sum = a + b;
					break;
				case "-" :
					sum = a - b;
					break;
				case "*" :
					sum = a * b;
					break;
				case "/" :
					sum = a / b;
					break;
				case "%" :
					sum = a % b;
					break;
				default:
					System.out.println("�����ȣ �����Դϴ�");
					System.exit(0); //�ý��� ����
			}return sum;
	
	}

}