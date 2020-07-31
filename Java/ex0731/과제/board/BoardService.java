class BoardService 
{
	Board [] boardArr = new Board[10]; //최대 10개까지 저장 가능 
	int count;

	//초기치 데이터 세팅하는 생성자 작성
	BoardService(String [][] data){ //생성자다 //String [][] data = data;
	//5개는 무조건 넣고 할꺼다 -> Board 클래스에 인수 4개받는 생
		
	//5개의 데이터 배열넣기	
		for(int i=0; i<data.length; i++){
	
			boardArr[i] = this.create(data[i]); //1차원 배열을 가지고 create 호출
			count ++;
		}
	}


	//생성자 Board 객체를 생성해서 리턴해주는 메소드
	private Board create(String [] row){ //{"1","java수업","장희정","너무재밌다"}
		return new Board(Integer.parseInt(row[0]),row[1],row[2], row[3]);
	
	}

	//등록메소드
	// : 추가전에 배열방에 board를 넣을 수 있는지 체크하고 
	// : 없으면 " 더 이상 추가할 수 없습니다" / 있으면 추가한다 
	public void insert(Board board){
		
	}


	//전체검색 - 전체 출력 메소드
	public void selectAll(){
		System.out.println("******게시물 List ("+count+") 개");
		for(int i = 0; i<count; i++){
			System.out.print("no :" + boardArr[i].getNo() + "\t");
			System.out.print("subject :" + boardArr[i].getSubject() + "\t");
			System.out.print("writer :" + boardArr[i].getWriter() + "\t");
			System.out.print("content :" + boardArr[i].getContent() + "\n");

		}
	
	}


	//부분검색(글번호에 해당하는 게시물 검색
	//			-> 글번호 있으면 "글번호 제목 작성자 내용" 출력
	//			->        없으면 "글번호는 존재하지 않습니다" 출력

	public void searchByNo(int no){
	
	}


	//수정
	//글번호에 해당하는 작성자와 내용만 수정 
	//  : 이경우 인수 3개받는 생성자를 이용해서 받는다
	//  : 글번호에 해당하는 정보가 있으면 
	//    -> 그 글번호에 해당하는 작성자, 내용을 전달받은 값으로 변경
	//    -> 없으면 "글번호 오류로 수정할 수 없습니다" 
	public void update(Board board){
		
	
	}


}
