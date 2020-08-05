class EndView{ //안에 method는 전역변수 선언하고 접근할 일이 없다
   /**
     전체출력
   */
   public static void printAll(Sing [] sArr){
	System.out.println();
	System.out.println("=====멜론 주간 차트 =====");
	for(int i=0; i<SingService.count; i++){
		if(sArr[i].getSingRank() != 0)  {
			System.out.print("Rank: "+sArr[i].getSingRank()+" ");
			System.out.print("Title: "+sArr[i].getSingTitle()+" ");
			System.out.print("Singer: "+sArr[i].getSingSinger()+" ");
			System.out.println();
		}else{
			System.out.println();
			continue;
		}
		
	}System.out.println();

   }

   /**
     모델번호에 해당하는 정보 출력
   */
   public static void printSearchByModelNo(Sing sing){
	   if(sing.getSingRank() != 0){
		System.out.print("Rank: "+sing.getSingRank()+", ");
		System.out.print("Title: "+sing.getSingTitle()+", ");
		System.out.print("Singer: "+sing.getSingSinger()+", ");
		System.out.println();
	   }else{
		System.out.println("노래를 삭제했습니다.");
	   }
	   }

   

   /**
     메세지 출력
   */
   public static void printMessage(String message){
	   System.out.println(message);
	   System.out.println();

   }

 //제목만 출력
   public static void printSearchByModelTitle(Sing sing){
		System.out.print("Rank: "+sing.getSingRank()+", ");
		System.out.print("Title: "+sing.getSingTitle()+", ");
		System.out.print("Singer: "+sing.getSingSinger()+", ");
		System.out.println();
	   }

	public static void printSearchByModelSinger(Sing sing){
		System.out.print("현재 Rank: "+sing.getSingRank()+"를 ");
		System.out.print("부른 가수는 : "+sing.getSingSinger()+"입니다.");
		System.out.println();
	   }

}