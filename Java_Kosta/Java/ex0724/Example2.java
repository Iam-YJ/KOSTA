class Example2{

	public static void main (String [] args){
		
		int month = (int)(Math.random()*12+1);
		int days ;

		switch(month){
			case 2:
				days = 28;
				break;
			case 4 : case 6 : case 9 : case 11:
				days = 30;
				break;
			default:
				days = 31;
		
		}
		System.out.println(month+"월달은 "+days+"일까지 입니다");
	}	
}