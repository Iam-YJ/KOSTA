class EndView{ //�ȿ� method�� �������� �����ϰ� ������ ���� ����
   /**
     ��ü���
   */
   public static void printAll(Electronics [] elecArr){
	System.out.println();
	System.out.println("=====������ǰ List =====");
	for(int i=0; i<ElectronicsService.count; i++){
		System.out.println(elecArr[i]);
		/*
		System.out.print("modelNo:"+elecArr[i].getModelNo()+" ");
		System.out.print("modelName"+elecArr[i].getModelName()+" ");
		System.out.print("modelPrice:"+elecArr[i].getModelPrice()+" ");
		System.out.print("modelDetail:"+elecArr[i].getModelDetail()+" ");
		*/
		System.out.println();
	}System.out.println();

   }

   /**
     �𵨹�ȣ�� �ش��ϴ� ���� ���
   */
   public static void printSearchByModelNo(Electronics electronics){
		System.out.println(electronics);
		
		/*
		System.out.print("modelNo:"+electronics.getModelNo()+", ");
		System.out.print("modelName"+electronics.getModelName()+", ");
		System.out.print("modelPrice:"+electronics.getModelPrice()+", ");
		System.out.print("modelDetail:"+electronics.getModelDetail()+" ");
		System.out.println();
		*/
	   }

   

   /**
     �޼��� ���
   */
   public static void printMessage(String message){
	   System.out.println(message);
	   System.out.println();

   }

}