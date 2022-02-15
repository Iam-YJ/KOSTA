package board;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//호출해보자
		//필드를 이용한 다형성
		
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
	
	//매개변수 (인수)를 이용한 다형성
	
	public static void test(BoardInterface board) { //free.. qa.. upload	
													//모두 들어갈 수 있음
		board.insert(new Board());
		board.selectByNo(10);
		board.delete(10);
		
		BoardInterface.update(new Board());
	}

}
