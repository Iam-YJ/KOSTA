import java.util.Scanner;

public class MenuView {
   Scanner sc = new Scanner(System.in);//키보드입력 준비
   ElectronicsController controller = new ElectronicsController();
    /**
	  메뉴를 출력하는 메소드
	*/
    public void printMenu(){
	   while(true){
		 System.out.println();
		 System.out.println("========== 메뉴를 선택해주세요 ==========");
		 System.out.println("1.등록  2.전체검색  3.부분검색  4.수정하기   9.종료");
         int no = sc.nextInt();
		 switch(no){
             case 1:  this.inputInsert() ; break;
			 case 2:   controller.selectAll() ;  break;
			 case 3:   inputSearch() ; break;
			 case 4:   inputUpdate() ; break;
			 case 9:   
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
       System.out.print("모델번호 ? ");
	   int modelNo = sc.nextInt();

	   System.out.print("모델이름 ? ");
	   String modelName = sc.nextLine();

	   System.out.print("모델가격 ? ");
	   int modelPrice = sc.nextInt();

	   System.out.print("모델설명 ? ");
	   String modelDetail = sc.nextLine();

        // 입력된 정보 4개를 하나의 Electronics객체로 만든다.
         Electronics electronics = 
			 new Electronics(modelNo, modelName,modelPrice,modelDetail);

         controller.insert(electronics);
	}

	/**
	  부분검색할 필요한 정보 입력받는 메소드
	*/
	public  void inputSearch(){
        System.out.print("검색할 모델번호?");
		int modelNo = sc.nextInt();
		controller.searchByModelNo(modelNo);
	}

	/**
	  수정할때 필요한 정보 입력 받는 메소드
	  ( 모델번호에 해당하는 전자제품 모델가격, 설명 변경 하기) 
	*/
    public void inputUpdate(){
      System.out.print("수정할 모델번호는 ? ");
	   int modelNo = sc.nextInt();

	   System.out.print("수정할 모델설명은 ? ");
	   String modelDetail = sc.next();


       Electronics electronics = 
			 new Electronics(modelNo,modelDetail);

         controller.update(electronics);

	}
}
