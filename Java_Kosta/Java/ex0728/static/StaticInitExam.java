class StaticInitExam{
	public static void main(String [] args){
		System.out.println("**메인 시작합니다**");

		System.out.println("**메인 종료합니다**");
	
	}

	static{
		System.out.println("난 무조건 main보다 먼저 실행됩니다");
		//초기화작업, 환경세팅, 초기치데이터 로딩, DB연결... 
	}


}