public class LottoTest {
	int lotto [] = new int [6];//0
    int cnt=0;//배열방에 중복없이 숫자가 들어간 개수.
    /**
     * 로또 번호 한개 생성하여 기존 로또번호와 비교하여 같으면 다시 생성.
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
     * 로또번호 비교하는 부분
	    return : true : 중복아님, false이면 중복 * */
    public boolean isCompareNo(int lottoNo ){
    	for(int i=0; i < cnt ; i++){
    		if(lotto[i] == lottoNo ){
    		  return false;
    		}
    	}
    	return true;   	
    }
    
    
    /**
     * 완성된 6개 번호 정렬하기
     * */
     public void lottoSort(){
    	 int temp=0;
		 //선택정렬방식..
			for(int i=0;i< lotto.length;i++){
				for(int j=(i+1);j<lotto.length;j++){
					if(lotto[i] < lotto[j]){
						temp = lotto[i];
						lotto[i] = lotto[j];
						lotto[j] = temp;		
					}
				}
			}//반복문끝
     }
     

     /**
      * 출력하는 메소드
      * */
     public void printLotto(){
     	//출력
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
