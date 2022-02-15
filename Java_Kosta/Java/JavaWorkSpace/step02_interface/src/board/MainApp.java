package board;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ȣ���غ���
		//�ʵ带 �̿��� ������
		
		BoardInterface board = null;
		
		System.out.println("************;");
		board = new QABoardImpl();
		test(board);
		
		System.out.println("************;");
		board = new FreeBoardImpl();
		test(board);
		
		System.out.println("************;");
		board = new UploadBoardImpl();
		test(board);
		
				
		
	}
	
	//�Ű����� (�μ�)�� �̿��� ������
	
	public static void test(BoardInterface board) { //free.. qa.. upload	
													//��� �� �� ����
		board.insert(new Board());
		board.selectByNo(10);
		board.delete(10);
		
		BoardInterface.update(new Board());
	}

}
