class Score {
	
	private int getSum(int kor, int eng, int math){
		
		return kor + eng + math ; 
	}

	private double getAvg(int total, int subjectCount){
		
		return total /(double)subjectCount;
	}

	private char getGrade(double avg){
		char ch = 'F';
		switch ((int)(avg/10)) {
		case 10:
			ch = 'A';
			break;

		case 9:
			ch = 'A';
			break;

		case 8:
			ch = 'B';
			break;

		case 7:
			ch = 'C';
			break;

		case 6:
			ch = 'D';
			break;

		default:
			ch = 'F';
	
	}

	public void print(String name, int kor, int eng, int math){
		int sum = this.getSum(kot, eng, math);
		double avg = this.getAvg(sum, 3);
		char grade = this.getGrade(avg);

		avg = (int)(avg*100)/100.0 ; 

		System.out.println("*****"+name+"님의 성적표 *****");
		System.out.println("국어점수 : " + kor + "\t"+"영어점수 : "+eng+"\t"+"수학점수 : "+math);
		System.out.println("총점 : " + sum + "\t"+"평균 : "+avg+"\t"+"등급 : "+grade);
		System.out.println("******************************");


	}


}