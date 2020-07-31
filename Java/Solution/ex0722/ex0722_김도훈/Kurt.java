/**
  º»ÀÎÀÌ¸§:±èµµÈÆ
  ³¯Â¥:  2020/7/22
  ÁÖÁ¦ : 
*/

class Kurt
{
public static void main(String [] args){  
 String name;
 int kor, eng, math;
 int total;  
 double Æò±Õ; 
char grade;
 name = ("±èµµÈÆ");
 kor = 100;  eng = 98; math = 80;
total = kor + eng + math;
Æò±Õ = total/3.0;
grade =  (Æò±Õ>=90) ? ('A') : ('F');
System.out.println("ÀÌ¸§:" + name);
System.out.println("±¹¾î:"+ kor);
System.out.println("¿µ¾î:"+eng);
System.out.println("¼öÇÐ:"+math);
System.out.print("ÃÑÁ¡:" + total  + "Æò±Õ" + Æò±Õ );
System.out.print("ÇÐÁ¡:" + grade);
}
}