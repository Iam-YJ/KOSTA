class  BoardMainApp
//a4 용지에 그리면서 하기 !!

{
	public static void main(String[] args) 
	{  //초기치 데이터 2차원 배열 준비
		String data[][] = new String[][]{
			{"1","가","A","너무재밌다"},
			{"2","나","B","너무재밌다"},
			{"3","다","C","너무재밌다"},
			{"4","라","D","너무재밌다"},
			{"5","마","E","너무재밌다"}
		
		};

		BoardService service = new BoardService(data); //전역변수 초기화하고
		System.out.println("1. 게시물 검색하기");
		service.selectAll();
	}
}