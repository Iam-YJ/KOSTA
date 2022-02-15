public class LottoTest {
	int lotto [] = new int [6];//0
    int cnt=0;//�迭�濡 �ߺ����� ���ڰ� �� ����.
    /**
     * �ζ� ��ȣ �Ѱ� �����Ͽ� ���� �ζǹ�ȣ�� ���Ͽ� ������ �ٽ� ����.
     * */
    public void createLottoNo(){		
		while(cnt < 6){//1
			 int lottoNo =(int)(Math.random()*45)+1;//5
			 if(  this.isCompareNo(lottoNo) ){
				 lotto[cnt] = lottoNo;
				 cnt++;
			 }
		}
    } 
    /**
     * �ζǹ�ȣ ���ϴ� �κ�
	    return : true : �ߺ��ƴ�, false�̸� �ߺ� * */
    public boolean isCompareNo(int lottoNo ){
    	for(int i=0; i < cnt ; i++){
    		if(lotto[i] == lottoNo ){
    		  return false;
    		}
    	}
    	return true;   	
    }
    
    
    /**
     * �ϼ��� 6�� ��ȣ �����ϱ�
     * */
     public void lottoSort(){
    	 int temp=0;
		 //�������Ĺ��..
			for(int i=0;i< lotto.length;i++){
				for(int j=(i+1);j<lotto.length;j++){
					if(lotto[i] < lotto[j]){
						temp = lotto[i];
						lotto[i] = lotto[j];
						lotto[j] = temp;		
					}
				}
			}//�ݺ�����
     }
     

     /**
      * ����ϴ� �޼ҵ�
      * */
     public void printLotto(){
     	//���
		for(int i=0; i< lotto.length ; i++){
     		System.out.print(lotto[i]+"\t");
     	}
     }
	
	public static void main(String[] args) {
		LottoTest lotto = new LottoTest();
		lotto.createLottoNo();
		lotto.lottoSort();
		lotto.printLotto();

	}
	

}
