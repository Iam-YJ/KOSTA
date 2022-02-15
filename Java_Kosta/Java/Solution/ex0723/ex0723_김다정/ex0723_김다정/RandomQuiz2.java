class RandomQuiz2{
	public static void main(String args[]){
	//1~12사이의 난수를 발생
	int month = (int)(Math.random()*12)+1;

	//숫자에 따라 그 달이 며칠까지 있는지 구하기
	//윤달은 고려하지 않는다.
	//출력내용: X월은 YY일까지입니다. 출력
	//1 3 5 7/ 8 10 12가 31일까지 =>month가 9보다 작고 홀수이거나(1,3,5,7) 8보다 크거나 같으면서 짝수(8,10,12)
	//4 6 9 11아 30일까지=>month가 2보다크고 8보다작은데 짝수이거나(4,6) 8보다 크면서 홀수(9,11)
	//2가 28일까지=>그 외
	if(month == 2){
		System.out.println(month+"월은 28일까지입니다.");
	}else if(month<9 && month %2!=0){
		System.out.println(month+"월은 31일까지입니다.");
	}else if(month>=8 && month%2==0){
		System.out.println(month+"월은 31일까지입니다.");
	}else if(month>2 && month <8){
		if(month%2==0){
		System.out.println(month+"월은 30일까지입니다.");
		}
	}
	else if(month >8 &&month %2!=0){
		System.out.println(month+"월은 30일까지입니다.");
	}

	}
 }
