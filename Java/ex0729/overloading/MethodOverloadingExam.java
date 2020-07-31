//MethodOverloadingExam.java
class OverloadedMethod{
	private int i; //전역변수
       
	public void  setOverload(int i){ //지역변수
		this.i = i; //인수로 전달받은 값을 전역변수에 저장한다 
	}
	
	public int getOverload(){
		return i; //전역변수
	}
	
	//setOverload를 Overloading하세요. 리턴도 하세요.
	public boolean setOverload(boolean b){ 
		return b;
	}
	
	//setOverload를 또 Overloading 하세요. 또 다른 놈으로 리턴 하세요.
	public double setOverload(double d){ 
		this.i = i; 
		return d;
	}
	
	//setOverload를 또 또Overloading 하세요. 리턴 안해요
	public void  setOverload(char c){ 
		this.i = i; 
	}



	//getOverload를 Overloading하세요. 리턴도 하세요.
	public double getOverload(double d){
		return d; 
	}
	
	//getOverload를 또 Overloading 하세요. 또 다른 놈으로 리턴 하세요.
	public char getOverload(char c){
		return c; 
	}
	
	//getOverload를 또 또Overloading 하세요. 리턴 안해요
	public void getOverload(boolean b){
	}

		
	
}

class  MethodOverloadingExam{3.
       
  public static void main(String [] agr){
     //OverloadedMethod객체에서 호출가능한  메소드들을 한번씩 호출하세요.
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

