class ArgsExam 
{
	public static void main(String[] args) 
	{
		//System.out.println("args="+args.length);
		if(args.length > 0){
			//�μ��� ���޵� ���� ���
			for(int i=0; i<args.length; i++){
				System.out.println(i+"��° �� "+args[i]+"\t");
			}
		}

		//�μ��� 2�� ���� ���޵ȴٴ� �����Ͽ� �� ���� ���� ���ϱ�

		System.out.println("�μ��� �� ������ : " + ( args[0] + args[1]));

		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);


		System.out.println("�μ��� �� ������  : " + ( a + b));

		/**
		String(���ڿ�) --> int(����) ��ȯ
			int no = Integer.parseInt(String s);
		
		int(����) --> String(���ڿ�) ��ȯ 
			String s = Integer.toString(int no);
			//��ü�� �����̳� ���� -> String����
			
		**/

	}
}

/* ������ ��
java ArgsExam �� �� ...
*/