/**
  �����̸�: �̼���
  ��¥: 2020.07.22
  ���� : �������ϱ�
*/
class Score {
    public static void main(String [] args) {
        int kor=0, eng=0, math=0, sum=0;

        String name = "�̼���";
        double avg;//���
        char gpa;//���
      
        kor = 85;
        eng = 96;
        math = 88;
        sum = kor + eng + math;//����
        avg = sum / 3.0;//���

        gpa = (avg  >= 90) ? 'A' : 'F';
        System.out.println("��ȯ �� avg : " + avg);
        //�Ҽ��� 2�ڸ����� 
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