class BooleanOPeratorExam{
	public static void main(String args[]){
		boolean  t=true ;
		boolean f=false;
		System.out.println("true&false="+(t&f)); //f
		System.out.println("true&true="+(t&t)); // t
		System.out.println("false&false="+(f&f)); //f
		System.out.println();
	
		System.out.println("true|false="+(t|f)); // t
		System.out.println("true|true="+(t|t)); // t
		System.out.println("false|false="+(f|f)); //f
		System.out.println();

		System.out.println("true^false="+(t^f)); //t
		System.out.println("true^true="+(t^t)); //f
		System.out.println("true^false="+(t^f)); // t
		System.out.println("true^true="+(t^t)); //f
		System.out.println();

		System.out.println("true&&false="+(t&&f)); //f
		System.out.println("true&&true="+(t&&t)); //t
		System.out.println("true&&false="+(t&&f)); //f
		System.out.println("false&&false="+(f&&f)); //f
		System.out.println();

		System.out.println("true||false="+(t||f)); //t
		System.out.println("true||true="+(t||t)); //t
		System.out.println("false||false="+(f||f)); //f
		System.out.println();

		int i=5; int j=3;
		System.out.println("int i="+i+"\tint j="+j); //5,3
		System.out.println("i>=j==>>"+(i>=j)); // t
		System.out.println("i>j=>>"+(i>j)); //t
		System.out.println("i<=j=>>"+(i<=j)); //f 
		System.out.println("i<j=>>"+(i<j)); //f
		System.out.println("i==j=>>"+(i==j)); //f
		System.out.println("i!=j=>>"+(i != j)); // t

		System.out.println("--------------");
		System.out.println(true | test() ); //true
		System.out.println(true || test() ); //true
		

	}
	
	public static boolean test(){
		System.out.println("난 호출되나?");
		return false;
}


}