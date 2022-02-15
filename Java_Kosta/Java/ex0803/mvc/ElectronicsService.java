
/**
  전자제품을 관리하는 클래스(등록, 수정, 검색,...)
   : 싱글톤클래스로 만든다.
*/
class ElectronicsService{

	private static ElectronicsService instance = new ElectronicsService();
    private Electronics [] elecArr = new Electronics [10];

    public static int count; //현재 배열에 몇개의 Electronics가 저장되었는지 체크하는 변수

    //전자제품 초기치 데이터
	String [][] data = new String [][]{
		{"1" ,"에어컨","350000","무풍 에어컨 짱 시원"},
        {"2","세탁기","325000","LG 세탁기..."},
        {"3","건조기","530000","건조기 강추!!!"},
        {"4","선풍기","38000","바람이 끝내 줘요."},
		{"5","전자렌지","150000","냉동식품 잘 녹아요.."}	 
	};

   /**
     외부에서 객체생성안됨.
	 전자제품 초기치 데이터 세팅
   */
   private ElectronicsService(){
      //기능작성
	  for(int i=0; i< data.length ; i++){
	    elecArr[count++] = 
			new Electronics(Integer.parseInt(data[i][0])  ,data[i][1], Integer.parseInt(data[i][2]),data[i][3] );
	  }
   }

   /**
     현재객체를 리턴해주는 메소드 제공
   */
   public static ElectronicsService getInstance(){
        return instance;
   }

   /**
     전체검색
   */
    public Electronics[] selectAll(){
        return elecArr;
	}

   /**
     등록하기
	 @return : true이면 등록성공, false이면 등록실패
   */
   public boolean insert(Electronics electronics){

	   if(elecArr.length == count){
           return false;
	   }

       elecArr[count++] = electronics;
       return true;
   }

   /**
     모델번호에 해당하는 제품 검색하기
   */
   public Electronics searchByModelNo(int modelNo){
        for(int i=0; i< ElectronicsService.count ; i++){
              if( elecArr[i].getModelNo() == modelNo ){
                  return elecArr[i];
			  }
		}

		return null; //못찾았다.
   }
   

   /**
     모델번호에 해당하는 제품 수정하기(설명만 수정하기)
	 @retrun : true이면 수정성공, false이면 수정실패
   */
  
   public boolean update(Electronics electronics){
        Electronics  searchElec =  this.searchByModelNo( electronics.getModelNo() );

		if(searchElec==null)return false;

		//찾았다...-> 수정해주자.
        searchElec.setModelDetail( electronics.getModelDetail() );
        return true;
   }




}//클래스끝