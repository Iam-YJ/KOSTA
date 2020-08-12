

import java.util.Arrays;

import java.util.Arrays;
public class InsertSort {
    
	public void algorithm(int[] arr){//{5,2,4,6,1,3}
		System.out.println("정렬 전 = " + Arrays.toString(arr)); 

		int num = 0, j = 0;	
		// 배열 갯수 만큼 반복
		for (int i=1; i< arr.length; i++){ // {5,2,4,6,1,3};
			num = arr[i]; //key값을 따로 num 에 담아둔다.
			System.out.println("키값>"+num);//2
			//정렬된 리스트 중, 키값보다 요소값이 클 경우 동안 반복
			for (j=i-1; j >= 0 &&  num < arr[j] ; j--){//
				arr[j+1] = arr[j]; // 정렬된리스트의 값을 다음 요소에 저장 (복사개념)
				System.out.println("과정>"+Arrays.toString(arr));
			}
			arr[j+1] = num; // key값을 삽입 

			
			System.out.println("결과> j ="+ j+" | " +Arrays.toString(arr));
		}

		System.out.println("\n정렬후 "+Arrays.toString(arr));
	}

	public static void main (String[] args){
		int [] arr = {5,2,4,6,1,3};

		InsertSort is  = new InsertSort();
		is.algorithm(arr);
	} 
}
