
class Test
{	//�ܺο��� ��ü�� �������� ���ϵ��� �� (Ŭ���� �ܺ�)
	private Test(){
		private static Test t = new Test();
		//������ ��������� �ؼ� -> �����ڸ� �� �� �ּҰ��� ��� ���� �̱��� ����
	}

	//���������� ���� ��ü�� �����ؼ� �������ִ� �޼ҵ� �����ؾ���
	// -> ����ڰ� ������� �������� ���ϰ� �ϰ� �����ڰ� �����ϴ� ������θ� ����� �� �ֵ���

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
		//���������� x. ���� ������ִ� ������θ� ������ �� �� �ְ� �Ѵ�.


		System.out.println("t1 = "+ t1);
		System.out.println("t2 = "+ t2);
	}
}
