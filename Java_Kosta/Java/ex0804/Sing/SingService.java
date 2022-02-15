
/**
  ������ǰ�� �����ϴ� Ŭ����(���, ����, �˻�,...)
   : �̱���Ŭ������ �����.
*/
class SingService{

	private static SingService instance = new SingService();
    private Sing [] sArr = new Sing [10];

    public static int count; //���� �迭�� ��� Electronics�� ����Ǿ����� üũ�ϴ� ����

    //������ǰ �ʱ�ġ ������
	String [][] data = new String [][]{
		{"1" ,"�ٽ� ���� �ٴ尡","�Ͼ���(���η���, ����G, ���)"},
        {"2","������(Maria)","ȭ��(Hwa Sa)"},
        {"3","�� ������ Ʋ����","�Ͼ��� (���η���, ����G, ���)"},
        {"4","How You Like That","BLACKPINK"},
		{"5","Summer Hate (Feat. ��)","���� (ZICO)"}	 
	};

   /**
     �ܺο��� ��ü�����ȵ�.
	 ������ǰ �ʱ�ġ ������ ����
   */
   private SingService(){
      //����ۼ�
	  for(int i=0; i< data.length ; i++){
	    sArr[count++] = 
			new Sing(Integer.parseInt(data[i][0])  ,data[i][1], data[i][2] );
	  }
   }

   /**
     ���簴ü�� �������ִ� �޼ҵ� ����
   */
   public static SingService getInstance(){
        return instance;
   }

   /**
     ��ü�˻�
   */
    public Sing[] selectAll(){
        return sArr;
	}

   /**
     ����ϱ�
	 @return : true�̸� ��ϼ���, false�̸� ��Ͻ���
   */
   public boolean insert(Sing sing){

	   if(sArr.length == count){
           return false;
	   }

       sArr[count++] = sing;
       return true;
   }

   /**
     �𵨹�ȣ�� �ش��ϴ� ��ǰ �˻��ϱ�
   */
   public Sing searchByModelNo(int singRank){
        for(int i=0; i< SingService.count ; i++){
              if( sArr[i].getSingRank() == singRank ){
                  return sArr[i];
			  }
		}

		return null; //��ã�Ҵ�.
   }
   

   /**
     �𵨹�ȣ�� �ش��ϴ� ��ǰ �����ϱ�(���� �����ϱ�)
	 @retrun : true�̸� ��������, false�̸� ��������
   */
  
   public boolean update(Sing sing){
        Sing  searchSing =  this.searchByModelNo( sing.getSingRank() );

		if(searchSing==null)return false;

		//ã�Ҵ�...-> ����������.
        searchSing.setSingTitle( sing.getSingTitle() );
		searchSing.setSingSinger( sing.getSingSinger() );
        return true;
   }






}//Ŭ������