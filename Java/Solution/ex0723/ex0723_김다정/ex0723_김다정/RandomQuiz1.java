class RandomQuiz1{
	public static void main(String args[]){

/* 1~10사이의 난수를 발생
발생한 난수가 1이면 일요일
2이면 월요일
3이면 화 4 수 5 목 6금 이외의 값이면 토요일 출력 */

	int day = (int)(Math.random()*10)+1;
		//System.out.println(day);
		if(day==1){
		System.out.println(day+":일요일");
		}else if(day==2){
		System.out.println(day+":월요일");
		}else if(day==3){
		System.out.println(day+":화요일");
		}else if(day==4){
		System.out.println(day+":수요일");
		}else if(day==5){
		System.out.println(day+":목요일");
		}else if(day==6){
		System.out.println(day+":금요일");
		}else{
		System.out.println(day+":토요일");
		}
  }
}