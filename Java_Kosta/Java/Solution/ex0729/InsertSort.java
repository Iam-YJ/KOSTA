

import java.util.Arrays;

import java.util.Arrays;
public class InsertSort {
    
	public void algorithm(int[] arr){//{5,2,4,6,1,3}
		System.out.println("���� �� = " + Arrays.toString(arr)); 

		int num = 0, j = 0;	
		// �迭 ���� ��ŭ �ݺ�
		for (int i=1; i< arr.length; i++){ // {5,2,4,6,1,3};
			num = arr[i]; //key���� ���� num �� ��Ƶд�.
			System.out.println("Ű��>"+num);//2
			//���ĵ� ����Ʈ ��, Ű������ ��Ұ��� Ŭ ��� ���� �ݺ�
			for (j=i-1; j >= 0 &&  num < arr[j] ; j--){//
				arr[j+1] = arr[j]; // ���ĵȸ���Ʈ�� ���� ���� ��ҿ� ���� (���簳��)
				System.out.println("����>"+Arrays.toString(arr));
			}
			arr[j+1] = num; // key���� ���� 

			
			System.out.println("���> j ="+ j+" | " +Arrays.toString(arr));
		}

		System.out.println("\n������ "+Arrays.toString(arr));
	}

	public static void main (String[] args){
		int [] arr = {5,2,4,6,1,3};

		InsertSort is  = new InsertSort();
		is.algorithm(arr);
	} 
}
