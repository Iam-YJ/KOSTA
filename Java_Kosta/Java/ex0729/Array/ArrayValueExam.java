
class ArrayValue{
	//������ 10�� �����ϴ� �迭����(����� ���ÿ� ���ǰ� ����)
	int [] arr = {1,2,3,4,5,6,7,8,9,10};


   /*printArrayvalue �޼ҵ��ۼ�
       => �޼ҵ� �ȿ��� ���� ����� �迭���� ���� ����Ѵ�.
   
	*/			
	public void printArrayvalue(){
		for(int i=0; i<10; i++){
			System.out.print(arr[i]+"\t"); 
			//���������̹Ƿ� �μ��� ������ �ʿ䰡 ���� 
		
		}
	}


}

/////////////////////////////////////////////////
class ArrayValueExam{
	public static void main(String args []){
        // ArrayValue�� �ִ� printArrayvalue�޼ҵ� ȣ��

		ArrayValue av = new ArrayValue();
		av.printArrayvalue();
		
		// new ArrayValue().printArrayvalue(); ����. ��ȸ�� 

	}
}