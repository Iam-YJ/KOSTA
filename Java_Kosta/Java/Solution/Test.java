class Test{


public static void main(String [] args){
String name = "¹ÚÀ¯Áø";
int kor=70;
int eng=60;
int math=100;
int sum=kor + eng + math;
double avg=sum/3.0;
char grade=avg>=90 ? 'A': 'F';

System.out.println(name);
System.out.println(kor);
System.out.println(eng);
System.out.println(math);
System.out.println(sum);
System.out.println(avg);
System.out.println(grade);

}
}