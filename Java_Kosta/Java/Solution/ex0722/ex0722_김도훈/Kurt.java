/**
  �����̸�:�赵��
  ��¥:  2020/7/22
  ���� : 
*/

class Kurt
{
public static void main(String [] args){  
 String name;
 int kor, eng, math;
 int total;  
 double ���; 
char grade;
 name = ("�赵��");
 kor = 100;  eng = 98; math = 80;
total = kor + eng + math;
��� = total/3.0;
grade =  (���>=90) ? ('A') : ('F');
System.out.println("�̸�:" + name);
System.out.println("����:"+ kor);
System.out.println("����:"+eng);
System.out.println("����:"+math);
System.out.print("����:" + total  + "���" + ��� );
System.out.print("����:" + grade);
}
}