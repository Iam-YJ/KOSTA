
public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee e = new Employee();
		FullTime f = new FullTime();
		PartTime p = new PartTime();
		
		Employee [] eArr = new Employee [5];
		FullTime [] full = {
			new FullTime (10, "유재석", "개그우먼", 0 , "2013-05-01", "무한도전",8500,200),
			new FullTime (20, "박명수", "가수",10, "2013-06-20", "무한도전",7500,100),
			new FullTime (30, "정준하", "예능인",10 , "2013-06-22", "무한도전",6000,0)
		};
		
		PartTime [] part = {
				new PartTime(40, "노홍철", "예능인",20 , "2014-05-01", "무한도전",20000),
				new PartTime(50, "하하", "가수",30 , "2014-05-02", "무한도전",25000)
		};
		
		
		for(int i=0; i<full.length; i++) {
			eArr[i] = full[i];
		}
		
		for(int i=0; i<part.length; i++) {
			eArr[i+3] = part[i];
		}
		
		
		
		System.out.println("********** Emp 정보 **********");
		for(int i=0; i<eArr.length; i++){
			System.out.println(eArr[i]);
			//System.out.println(eArr[i].toString());
			//부모쪽에 있어도 재정의된 메소드는 자식꺼가 나온다
		}
		System.out.println();
		
		

		System.out.println("********** Emp Message 정보 **********");
		for(int i=0; i<eArr.length; i++){
			eArr[i].message();
			System.out.println();
		}
		System.out.println();
	
		
		

		

	}

}






