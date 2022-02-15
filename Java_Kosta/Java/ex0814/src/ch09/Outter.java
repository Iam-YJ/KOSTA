package ch09;

public class Outter {
	
	final int localVariable = 1;
	//arg = 100;
	//localVariable = 100;
	
	class Inner{
		public void method1(final int arg) {
			int result = arg + localVariable;
		}
	}
	
	public void method2(int arg) {
		int localVariable = 1;
		//arg = 100;
		//localVariable - 100;
		
		class Inner{
			public void method() {
				int result = arg + localVariable;
			}
		}
	}

}
