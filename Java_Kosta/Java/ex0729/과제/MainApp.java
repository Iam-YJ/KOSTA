class Lotto {

	int arr[] = new int[6];
	int cnt = 0;

	// �ߺ�üũ �޼ҵ�
	public int overLap() {
		boolean flag = true;

		for (int i = 0; i < arr.length; i++) {
			n = (int) (Math.random() * 45 + 1);
		}
		
		//�ߺ� ������ 
		
		}		
		
		return n;

	} 


//������ �ڵ� 
	/* public void createLottoNo(){
	
		while(cnt < 6){
			int lottoNo = (int)(Math.random() * 45)+1;
			if(this.isCompareNo(lottoNo){
				lotto[cnt] = lottoNo;
				cnt++;
			
			}
					//�ߺ�üũ - return true:�ߺ��ƴ� / false �ߺ�
		public boolean isCompareNo(int lottoNo){
			for(int i=0; i<cnt; i++){
				if(lotto[i] == lottoNo){
					return false;
				
				}
			}return true;
		}
	
	} */
//�������



	// ���� 6�� �迭�濡 �����ϴ� �޼ҵ�
	public void save() {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = overLap();
		}

	}

	// ��½� ������������ ����� ��
	public void sort() {
		System.out.println("�����ؿ�~");
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

	// �迭�� ȭ�鿡 ��� �޼ҵ�
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