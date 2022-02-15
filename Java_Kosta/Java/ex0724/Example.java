class Example{

 public static void main(String [] args){

	int random = (int)(Math.random() * 10 + 1);
	//1 일요일
	int day = random % 7;
	String days = "토";

	switch(day){
		case 1 :
			days = "일";
			break;
		case 2 : 
			days = "월";
			break;
		case 3 : 
			days = "화";
			break;
		case 4 : 
			days = "수";
			break;
		case 5 : 
			days = "목";
			break;
		case 6 : 
			days = "금";
			break;
	}
	System.out.println(day+"는 "+days+"요일 입니다."); 
 }


}