class Lotto {

	int arr[] = new int[6];
	int cnt = 0;

	// 중복체크 메소드
	public int overLap() {
		boolean flag = true;

		for (int i = 0; i < arr.length; i++) {
			n = (int) (Math.random() * 45 + 1);
		}
		
		//중복 못만듦 
		
		}		
		
		return n;

	} 


//선생님 코드 
	/* public void createLottoNo(){
	
		while(cnt < 6){
			int lottoNo = (int)(Math.random() * 45)+1;
			if(this.isCompareNo(lottoNo){
				lotto[cnt] = lottoNo;
				cnt++;
			
			}
					//중복체크 - return true:중복아님 / false 중복
		public boolean isCompareNo(int lottoNo){
			for(int i=0; i<cnt; i++){
				if(lotto[i] == lottoNo){
					return false;
				
				}
			}return true;
		}
	
	} */
//여기까지



	// 숫자 6개 배열방에 저장하는 메소드
	public void save() {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = overLap();
		}

	}

	// 출력시 내림차순으로 만드는 것
	public void sort() {
		System.out.println("정렬해요~");
		int temp;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}

			}

		}
	}

	// 배열값 화면에 출력 메소드
	public void print() {
		this.sort();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}

}

class MainApp {

	public static void main(String[] args) {
		Lotto l = new Lotto();
		l.save();
		l.print();

	}

}