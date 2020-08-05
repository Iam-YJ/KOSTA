
/**
  전자제품을 관리하는 클래스(등록, 수정, 검색,...)
   : 싱글톤클래스로 만든다.
*/
class SingService{

	private static SingService instance = new SingService();
    private Sing [] sArr = new Sing [10];

    public static int count; //현재 배열에 몇개의 Electronics가 저장되었는지 체크하는 변수

    //전자제품 초기치 데이터
	String [][] data = new String [][]{
		{"1" ,"다시 여기 바닷가","싹쓰리(유두래곤, 린다G, 비룡)"},
        {"2","마리아(Maria)","화사(Hwa Sa)"},
        {"3","그 여름을 틀어줘","싹쓰리 (유두래곤, 린다G, 비룡)"},
        {"4","How You Like That","BLACKPINK"},
		{"5","Summer Hate (Feat. 비)","지코 (ZICO)"}	 
	};

   /**
     외부에서 객체생성안됨.
	 전자제품 초기치 데이터 세팅
   */
   private SingService(){
      //기능작성
	  for(int i=0; i< data.length ; i++){
	    sArr[count++] = 
			new Sing(Integer.parseInt(data[i][0])  ,data[i][1], data[i][2] );
	  }
   }

   /**
     현재객체를 리턴해주는 메소드 제공
   */
   public static SingService getInstance(){
        return instance;
   }

   /**
     전체검색
   */
    public Sing[] selectAll(){
        return sArr;
	}

   /**
     등록하기
	 @return : true이면 등록성공, false이면 등록실패
   */
   public boolean insert(Sing sing){

	   if(sArr.length == count){
           return false;
	   }

       sArr[count++] = sing;
       return true;
   }

   /**
     모델번호에 해당하는 제품 검색하기
   */
   public Sing searchByModelNo(int singRank){
        for(int i=0; i< SingService.count ; i++){
              if( sArr[i].getSingRank() == singRank ){
                  return sArr[i];
			  }
		}

		return null; //못찾았다.
   }
   

   /**
     모델번호에 해당하는 제품 수정하기(설명만 수정하기)
	 @retrun : true이면 수정성공, false이면 수정실패
   */
  
   public boolean update(Sing sing){
        Sing  searchSing =  this.searchByModelNo( sing.getSingRank() );

		if(searchSing==null)return false;

		//찾았다...-> 수정해주자.
        searchSing.setSingTitle( sing.getSingTitle() );
		searchSing.setSingSinger( sing.getSingSinger() );
        return true;
   }






}//클래스끝