class  BoardMainApp
//a4 ������ �׸��鼭 �ϱ� !!

{
	public static void main(String[] args) 
	{  //�ʱ�ġ ������ 2���� �迭 �غ�
		String data[][] = new String[][]{
			{"1","��","A","�ʹ���մ�"},
			{"2","��","B","�ʹ���մ�"},
			{"3","��","C","�ʹ���մ�"},
			{"4","��","D","�ʹ���մ�"},
			{"5","��","E","�ʹ���մ�"}
		
		};

		BoardService service = new BoardService(data); //�������� �ʱ�ȭ�ϰ�
		System.out.println("1. �Խù� �˻��ϱ�");
		service.selectAll();
	}
}