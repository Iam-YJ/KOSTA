class EndView{ //�ȿ� method�� �������� �����ϰ� ������ ���� ����
   /**
     ��ü���
   */
   public static void printAll(Sing [] sArr){
	System.out.println();
	System.out.println("=====��� �ְ� ��Ʈ =====");
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
     �𵨹�ȣ�� �ش��ϴ� ���� ���
   */
   public static void printSearchByModelNo(Sing sing){
	   if(sing.getSingRank() != 0){
		System.out.print("Rank: "+sing.getSingRank()+", ");
		System.out.print("Title: "+sing.getSingTitle()+", ");
		System.out.print("Singer: "+sing.getSingSinger()+", ");
		System.out.println();
	   }else{
		System.out.println("�뷡�� �����߽��ϴ�.");
	   }
	   }

   

   /**
     �޼��� ���
   */
   public static void printMessage(String message){
	   System.out.println(message);
	   System.out.println();

   }

 //���� ���
   public static void printSearchByModelTitle(Sing sing){
		System.out.print("Rank: "+sing.getSingRank()+", ");
		System.out.print("Title: "+sing.getSingTitle()+", ");
		System.out.print("Singer: "+sing.getSingSinger()+", ");
		System.out.println();
	   }

	public static void printSearchByModelSinger(Sing sing){
		System.out.print("���� Rank: "+sing.getSingRank()+"�� ");
		System.out.print("�θ� ������ : "+sing.getSingSinger()+"�Դϴ�.");
		System.out.println();
	   }

}