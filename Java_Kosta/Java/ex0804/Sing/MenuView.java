import java.util.Scanner;

public class MenuView {
   Scanner sc = new Scanner(System.in);//키보드입력 준비
   SingController controller = new SingController();
    /**
	  메뉴를 출력하는 메소드
	*/
    public void printMenu(){
	   while(true){
		 System.out.println();
		 System.out.println("========== 메뉴를 선택해주세요 ==========");
		 System.out.println("1.전체목록  2.노래추가  3.노래수정 4.노래삭제 5. 부분검색 6. 종료");
         int no = sc.nextInt();
		 switch(no){
			 case 1:	controller.selectAll() ;  break;
             case 2:	this.inputInsert() ; break;
			 case 3:	inputUpdate(); break; //수정
			 case 4:	deleteSing(); break; //삭제
			 case 5:	searchTitle(); break; //제목검색 searchTitle
			 //case 6:	Reverse(); break; //가수검색 searchSinger
			 case 6:   
				 System.out.println("모든 프로그램 종료합니다...");
				 System.exit(0) ; //프로그램강제종료
			 break;
			 default: System.out.println("잘못된 선택번호입니다. 다시입력해주세요!");

		 }//switch문끝
	   }//while문끝  	
	}
	 
	/**
	  등록할때 필요한 정보 입력 받는 메소드
	*/
	public  void inputInsert(){
       System.out.print("노래순위 ? ");
	   int singRank = sc.nextInt();

	   System.out.print("노래제목 ? ");
	   String singTitle = sc.next();

	   System.out.print("가수 ? ");
	   String singSinger = sc.next();

        // 입력된 정보 4개를 하나의 Electronics객체로 만든다.
         Sing sing = 
			 new Sing(singRank, singTitle, singSinger);

         controller.insert(sing);
	}

	/**
	  부분검색할 필요한 정보 입력받는 메소드
	*/
	/*
	public  void inputSearch(){
        System.out.print("검색할 순위?");
		int singRank = sc.nextInt();
		controller.searchByModelNo(singRank);
	}
	*/

	/**
	  수정할때 필요한 정보 입력 받는 메소드
	  ( 모델번호에 해당하는 전자제품 모델가격, 설명 변경 하기) 
	*/
    public void inputUpdate(){
      System.out.print("수정할 노래 순위는 ? ");
	  int singRank = sc.nextInt();

	   System.out.print("수정할 노래제목은? ? ");
	   String singTitle = sc.next();
		
		System.out.print("수정할 가수는 ? ");
	   String singSinger = sc.next();


       Sing sing = 
			 new Sing(singRank, singTitle, singSinger);

         controller.update(sing);
	}

	//4번 삭제하기
	public void deleteSing(){
	System.out.print("삭제할 노래의 순위는 ? ");
	 int singRank = sc.nextInt();

	 controller.searchByModelNo(singRank);
	 

	}

//5번 제목 찾기
	public void searchTitle(){
	System.out.print("찾고싶은 노래의 순위는 ? ");
	 int singRank = sc.nextInt();

	 controller.searchByModelNo2(singRank);
	}




//6번 가수 찾기
	public void searchSinger(){
	System.out.print("찾고싶은 가수의 순위는 ? ");
	 int singRank = sc.nextInt();

	}



}
