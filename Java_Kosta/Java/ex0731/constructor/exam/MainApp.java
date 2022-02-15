import java.util.Scanner;

class MainApp 
{
	public static void main(String[] args) 
	{  

		StudentService ss = new StudentService();

		Scanner scan = new Scanner(System.in);

		System.out.println("======================");
		System.out.println("1. ");
		System.out.println("======================");



		//학생 정보를 추가
		ss.insert();
	
		//학생 전체 검색
		ss.selectAll();

		//이름으로 학생 검색
		ss.searchBy("유진0");
		ss.searchBy("유진10");
		
	}
}
