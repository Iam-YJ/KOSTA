import java.util.Arrays;

class Sort{
	public static void main(String[] args){
		int arr[] = {5,7,1,2,4,3,8,9,6,10};
		
		//System.out.println("정렬 전 = " + Arrays.toString(arr));

        //버블정렬방식 : 인접해 있는 데이터를 비교해서 큰값을 오른쪽 배치
		int j=0;//임시공간변수
		for(int a=0; a<arr.length-1; a++){// 9번...
			for(int i=0; i<arr.length-1; i++){//9
				if(arr[i] < arr[i+1]){ //0 1 , 1 2 , 2 3
					j = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = j;
				}
			}
		}
   

		//System.out.println("정렬 후 = "+Arrays.toString(arr));//배열방의 모든 값을 콤마를기준으로 출력
     
////////////////////////////////////////////////////////////




/*
     System.out.println("정렬 전 = " + Arrays.toString(arr));
		int temp=0;
		 //선택정렬방식.. : 왼쪽에 가장 작은 최소값을 배치..
			for(int i=0;i< arr.length;i++){//9
				for(int j=(i+1);j<arr.length;j++){
					// i가 0일때 :  0 1 , 0 2, 0 3
					//i가 1일대 : 1 2 , 1 3 , 1 4 
					if(arr[i] > arr[j]){// 0 1 , 0 2, 0 3
						temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;		
					}
				}
			}//반복문끝 

         System.out.println("정렬 후 = "+Arrays.toString(arr));

*/
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}

		
	}
}