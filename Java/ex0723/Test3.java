/**
본인이름: 박유진
날짜:20 07 23
주제: 난수발생, 제어문
*/



class Test3{


public static void main(String [] args){


String name = "박유진";
double kor=Math.random() * 56 +45;
double eng=Math.random() * 56 +45;
double math=Math.random() * 56 +45;
double sum=kor + eng + math;
double avg=sum/3.0;
int my = (int)(avg * 10) ;
double ravg = my / 10.0;
char grade = 'N';



if (avg >= 90)
{
	grade = 'A';
}else if (avg >= 80)
{
	grade = 'B';
}else if (avg >= 70)
{
	grade = 'C';
}else if (avg >= 60)
{
	grade = 'D';
}else 
{
	grade = 'F';
}

System.out.println("name " + name);
System.out.println("kor " + (int)kor);
System.out.println("eng " + (int)eng);
System.out.println("math " + (int)math);
System.out.println("sum " + (int)sum);
System.out.println("avg " + ravg);
System.out.println("grade " + grade);

}


}