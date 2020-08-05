class EndView{ //안에 method는 전역변수 선언하고 접근할 일이 없다
   /**
     전체출력
   */
   public static void printAll(Electronics [] elecArr){
	System.out.println();
	System.out.println("=====전자제품 List =====");
	for(int i=0; i<ElectronicsService.count; i++){
		System.out.print("modelNo:"+elecArr[i].getModelNo()+" ");
		System.out.print("modelName"+elecArr[i].getModelName()+" ");
		System.out.print("modelPrice:"+elecArr[i].getModelPrice()+" ");
		System.out.print("modelDetail:"+elecArr[i].getModelDetail()+" ");
		System.out.println();
	}System.out.println();

   }

   /**
     모델번호에 해당하는 정보 출력
   */
   public static void printSearchByModelNo(Electronics electronics){
		System.out.print("modelNo:"+electronics.getModelNo()+", ");
		System.out.print("modelName"+electronics.getModelName()+", ");
		System.out.print("modelPrice:"+electronics.getModelPrice()+", ");
		System.out.print("modelDetail:"+electronics.getModelDetail()+" ");
		System.out.println();
	   }

   

   /**
     메세지 출력
   */
   public static void printMessage(String message){
	   System.out.println(message);
	   System.out.println();

   }

}