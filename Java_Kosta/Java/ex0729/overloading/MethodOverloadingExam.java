//MethodOverloadingExam.java
class OverloadedMethod{
	private int i; //��������
       
	public void  setOverload(int i){ //��������
		this.i = i; //�μ��� ���޹��� ���� ���������� �����Ѵ� 
	}
	
	public int getOverload(){
		return i; //��������
	}
	
	//setOverload�� Overloading�ϼ���. ���ϵ� �ϼ���.
	public boolean setOverload(boolean b){ 
		return b;
	}
	
	//setOverload�� �� Overloading �ϼ���. �� �ٸ� ������ ���� �ϼ���.
	public double setOverload(double d){ 
		this.i = i; 
		return d;
	}
	
	//setOverload�� �� ��Overloading �ϼ���. ���� ���ؿ�
	public void  setOverload(char c){ 
		this.i = i; 
	}



	//getOverload�� Overloading�ϼ���. ���ϵ� �ϼ���.
	public double getOverload(double d){
		return d; 
	}
	
	//getOverload�� �� Overloading �ϼ���. �� �ٸ� ������ ���� �ϼ���.
	public char getOverload(char c){
		return c; 
	}
	
	//getOverload�� �� ��Overloading �ϼ���. ���� ���ؿ�
	public void getOverload(boolean b){
	}

		
	
}

class  MethodOverloadingExam{3.
       
  public static void main(String [] agr){
     //OverloadedMethod��ü���� ȣ�Ⱑ����  �޼ҵ���� �ѹ��� ȣ���ϼ���.
        OverloadedMethod om = new OverloadedMethod();

		om.setOverload(1);
		om.setOverload(true);
		om.setOverload(3.0);
		om.setOverload('4');

		om.getOverload();
		om.getOverload(2.0);
		om.getOverload('3');
		om.getOverload(false);


	}   


}

