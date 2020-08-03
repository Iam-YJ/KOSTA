class  BoardMainApp
//a4 용지에 그리면서 하기 !!

{
	public static void main(String[] args) 
	{  //초기치 데이터 2차원 배열 준비
		String data[][] = new String[][]{
			{"1","가","A","!"},
			{"2","나","B","@"},
			{"3","다","C","#"},
			{"4","라","D","$"},
			{"5","마","E","%"}
		
		};

		BoardService service = new BoardService(data); //전역변수 초기화하고
		System.out.println("1. 게시물 검색하기");
		service.selectAll();
		System.out.println();

		System.out.println("2. 게시물 등록하기");
		Board board = new Board(6,"바","F","^"); //생성자 호출된다
		service.insert(board);
		System.out.println();

		System.out.println("1. 게시물 검색하기");
		service.selectAll();
		System.out.println();

		System.out.println("1. 게시물 부분검색하기");
		service.searchByNo(3);
		System.out.println();

		
		System.out.println("4. 게시물 수정하기");
		service.update(new Board(4, "yy", "qq"));
		System.out.println();

		System.out.println("1. 게시물 검색하기");
		service.selectAll();
		System.out.println();
		


	}
}