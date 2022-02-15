class ArgsExam 
{
	public static void main(String[] args) 
	{
		//System.out.println("args="+args.length);
		if(args.length > 0){
			//인수로 전달된 값을 출력
			for(int i=0; i<args.length; i++){
				System.out.println(i+"번째 값 "+args[i]+"\t");
			}
		}

		//인수가 2개 숫자 전달된다는 가정하에 두 수의 합을 구하기

		System.out.println("두수의 합 변경전 : " + ( args[0] + args[1]));

		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);


		System.out.println("두수의 합 변경후  : " + ( a + b));

		/**
		String(문자열) --> int(숫자) 변환
			int no = Integer.parseInt(String s);
		
		int(숫자) --> String(문자열) 변환 
			String s = Integer.toString(int no);
			//주체가 무엇이냐 따라 -> String으로
			
		**/

	}
}

/* 실행할 때
java ArgsExam 값 값 ...
*/