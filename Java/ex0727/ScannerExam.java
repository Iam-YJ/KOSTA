import java.util.Scanner; 
// 내가 사용하려는 클래스가 어떤 폴더에 있는지 선언

class ScannerExam{

	public static void main(String [] args){
		//키보드 입력받기 위한 준비
		Scanner sc = new Scanner(System.in);

		//키보드 입력 받기
		System.out.print("숫자 입력 : ");
		int kor = sc.nextInt();

		System.out.print("숫자 입력 : ");
		int eng = sc.nextInt();

		System.out.print("이름 입력 : ");
		String name = sc.next();

		System.out.println("***성적표***");
		System.out.println(name+"님 성적은" + (kor+eng));
	
	}



}