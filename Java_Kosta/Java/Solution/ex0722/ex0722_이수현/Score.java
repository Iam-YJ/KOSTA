/**
  본인이름: 이수현
  날짜: 2020.07.22
  주제 : 성적구하기
*/
class Score {
    public static void main(String [] args) {
        int kor=0, eng=0, math=0, sum=0;

        String name = "이수현";
        double avg;//평균
        char gpa;//등급
      
        kor = 85;
        eng = 96;
        math = 88;
        sum = kor + eng + math;//총점
        avg = sum / 3.0;//평균

        gpa = (avg  >= 90) ? 'A' : 'F';
        System.out.println("변환 전 avg : " + avg);
        //소수점 2자리까지 
        avg = (int)(avg*100) / 100.0;

        System.out.println("name : " + name);
        System.out.println("kor : " + kor);
        System.out.println("eng : " + eng);
        System.out.println("math : " + math);
        System.out.println("sum : " + sum);
        System.out.println("avg : " + avg);
        System.out.print("gpa : " + gpa);
    }

}