class MultiArray{
//������ 2���� �迭 8*9
	int [][] arr = new int [8][9];

//�޼ҵ��̸� :array99
	
	//for loop �� ����Ͽ� 
	//�迭�� ���� (������)�������
	//�迭�� ����� �������

public void array99(){
	for(int i=0; i<arr.length; i++){
		for(int j=0; j<arr[i].length; j++){
			arr[i][j] = ((i+2)*(j+1));
		}
	}


	for(int i=0; i<arr.length; i++){
		for(int j=0; j<arr[i].length; j++){
			System.out.print(arr[i][j]+"\t");
		}System.out.println();
	}
}
		
	
		
		
}
public class MemoryApart{
//main�޼ҵ忡�� 
//MultiArray��ü�� array99�޼ҵ�ȣ��
	public static void main(String [] args){
		MultiArray ma = new MultiArray();

		ma.array99();
	}
	
}

