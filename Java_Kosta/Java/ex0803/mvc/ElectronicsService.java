
/**
  ������ǰ�� �����ϴ� Ŭ����(���, ����, �˻�,...)
   : �̱���Ŭ������ �����.
*/
class ElectronicsService{

	private static ElectronicsService instance = new ElectronicsService();
    private Electronics [] elecArr = new Electronics [10];

    public static int count; //���� �迭�� ��� Electronics�� ����Ǿ����� üũ�ϴ� ����

    //������ǰ �ʱ�ġ ������
	String [][] data = new String [][]{
		{"1" ,"������","350000","��ǳ ������ ¯ �ÿ�"},
        {"2","��Ź��","325000","LG ��Ź��..."},
        {"3","������","530000","������ ����!!!"},
        {"4","��ǳ��","38000","�ٶ��� ���� ���."},
		{"5","���ڷ���","150000","�õ���ǰ �� ��ƿ�.."}	 
	};

   /**
     �ܺο��� ��ü�����ȵ�.
	 ������ǰ �ʱ�ġ ������ ����
   */
   private ElectronicsService(){
      //����ۼ�
	  for(int i=0; i< data.length ; i++){
	    elecArr[count++] = 
			new Electronics(Integer.parseInt(data[i][0])  ,data[i][1], Integer.parseInt(data[i][2]),data[i][3] );
	  }
   }

   /**
     ���簴ü�� �������ִ� �޼ҵ� ����
   */
   public static ElectronicsService getInstance(){
        return instance;
   }

   /**
     ��ü�˻�
   */
    public Electronics[] selectAll(){
        return elecArr;
	}

   /**
     ����ϱ�
	 @return : true�̸� ��ϼ���, false�̸� ��Ͻ���
   */
   public boolean insert(Electronics electronics){

	   if(elecArr.length == count){
           return false;
	   }

       elecArr[count++] = electronics;
       return true;
   }

   /**
     �𵨹�ȣ�� �ش��ϴ� ��ǰ �˻��ϱ�
   */
   public Electronics searchByModelNo(int modelNo){
        for(int i=0; i< ElectronicsService.count ; i++){
              if( elecArr[i].getModelNo() == modelNo ){
                  return elecArr[i];
			  }
		}

		return null; //��ã�Ҵ�.
   }
   

   /**
     �𵨹�ȣ�� �ش��ϴ� ��ǰ �����ϱ�(���� �����ϱ�)
	 @retrun : true�̸� ��������, false�̸� ��������
   */
  
   public boolean update(Electronics electronics){
        Electronics  searchElec =  this.searchByModelNo( electronics.getModelNo() );

		if(searchElec==null)return false;

		//ã�Ҵ�...-> ����������.
        searchElec.setModelDetail( electronics.getModelDetail() );
        return true;
   }




}//Ŭ������