
class Test
{	//외부에서 객체를 생성하지 못하도록 함 (클래스 외부)
	private Test(){
		private static Test t = new Test();
		//생성을 멤버변수로 해서 -> 생성자를 할 때 주소값이 모두 같은 싱글톤 패턴
	}

	//내부적으로 현재 객체를 생성해서 리턴해주는 메소드 제공해야함
	// -> 사용자가 마음대로 생성하지 못하게 하고 개발자가 제공하는 방식으로만 사용할 수 있도록

	public static Test getInstance(){
		
		return t;
	}
}


class PrivateConstructureExam
{
	public static void main(String[] args) 
	{
		//Test t1 = new Test();
		//Test t2 = new Test();

		Test t1 = Test.getInstance();
		Test t1 = Test.getInstance();
		//직접생성은 x. 내가 만들어주는 모양으로만 가져다 쓸 수 있게 한다.


		System.out.println("t1 = "+ t1);
		System.out.println("t2 = "+ t2);
	}
}
