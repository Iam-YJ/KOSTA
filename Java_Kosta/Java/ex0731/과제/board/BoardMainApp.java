class  BoardMainApp
//a4 ������ �׸��鼭 �ϱ� !!

{
	public static void main(String[] args) 
	{  //�ʱ�ġ ������ 2���� �迭 �غ�
		String data[][] = new String[][]{
			{"1","��","A","!"},
			{"2","��","B","@"},
			{"3","��","C","#"},
			{"4","��","D","$"},
			{"5","��","E","%"}
		
		};

		BoardService service = new BoardService(data); //�������� �ʱ�ȭ�ϰ�
		System.out.println("1. �Խù� �˻��ϱ�");
		service.selectAll();
		System.out.println();

		System.out.println("2. �Խù� ����ϱ�");
		Board board = new Board(6,"��","F","^"); //������ ȣ��ȴ�
		service.insert(board);
		System.out.println();

		System.out.println("1. �Խù� �˻��ϱ�");
		service.selectAll();
		System.out.println();

		System.out.println("1. �Խù� �κа˻��ϱ�");
		service.searchByNo(3);
		System.out.println();

		
		System.out.println("4. �Խù� �����ϱ�");
		service.update(new Board(4, "yy", "qq"));
		System.out.println();

		System.out.println("1. �Խù� �˻��ϱ�");
		service.selectAll();
		System.out.println();
		


	}
}