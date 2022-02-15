import java.util.Scanner; 

class Symbol{
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		

		System.out.println("정수를 입력하세요 : ");
		int a = scan.nextInt();
		System.out.println("정수를 입력하세요 : ");
		int b = scan.nextInt();
		System.out.println("연산기호를 입력하세요(+,-,*,/,%) : ");
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
					System.out.println("연산기호 오류입니다");
					System.exit(0); //시스템 종료
			}return sum;
	
	}

}