//Error �� �����ϰ� ������ �ּ����� ó���ϼ���.

final class FinalClassExam{ //��ӺҰ�, �������� 
 final int i = -999999; //���, ������ �Ұ�, �ݵ�� �ʱ�ȭ �ʼ�(������������ �ʱ�ȭ�ؾ���)
}
/*
	final ���� �ʱ�ȭ ���
	1. ����� �ʱ�ȭ -> final int i = 100;
	2. �����ڸ� �̿��� �ʱ�ȭ 

	FinalClassExam (){
		i = 100;
	} -> ��ü�� �����Ǵ� ������ ����� �ʱ�ȭ ���� �� 

*/


abstract class AbstractClassExam{ //��Ӱ���, �����ȵ� 
    abstract String abstractMethodExam(int i,String s); //����� ����. �ڽ�Ŭ�������� �����Ǹ� ���� ����     
    //ex) ��� sound ����� -> �� Ŭ�������� ��ӹ޾� -> ��üȭ
	final int finalMethodExam(int i, int j){ //������ �Ұ� 
        return i+j;
    }
}


class Sample01 extends AbstractClassExam{
	@Overriding
	String abstractMethodExam(int i,String s){
		System.out.println("return "+s+i);
		return s+i;
	}
	
	/*int finalMethodExam(int i, int j){
		return i*j;
	}*/ //���� final�� �Ǿ��־ ������ �Ұ� 
	
}

class Sample02 /* extends FinalClassExam */ {  } //extends FinalClassExam �Ұ�. final�̿��� ��� �ȵ�


 
abstract class Sample03 extends AbstractClassExam{ //abstract ����� abstract�� 
	 String abstractMethodExam(int i,String s){
		return s+i;
	 }

	abstract String abstractMethodExam(); 
	// Abstract�� public abstract void aa(); ����θ� �ְ� ���� x

	void sampleMethod03(){
		System.out.println("void sampleMethod03() ȣ�� ��");
	}
}

class AbstractFinalClassTest{
    public static void main(String args[]){
		//AbstractClassExam ace = new AbstractClassExam(); 
		//abstract �� new ��� �Ұ� 
		FinalClassExam fce = new FinalClassExam();
//		fce.i=100000;
//final�� �� ���� �Ұ� (�������)
		Sample01 s01 = new Sample01();
		AbstractClassExam aceS01 = new Sample01();
		aceS01.abstractMethodExam(700,"_999");
	}
}
