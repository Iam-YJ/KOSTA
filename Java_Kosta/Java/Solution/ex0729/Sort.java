import java.util.Arrays;

class Sort{
	public static void main(String[] args){
		int arr[] = {5,7,1,2,4,3,8,9,6,10};
		
		//System.out.println("���� �� = " + Arrays.toString(arr));

        //�������Ĺ�� : ������ �ִ� �����͸� ���ؼ� ū���� ������ ��ġ
		int j=0;//�ӽð�������
		for(int a=0; a<arr.length-1; a++){// 9��...
			for(int i=0; i<arr.length-1; i++){//9
				if(arr[i] < arr[i+1]){ //0 1 , 1 2 , 2 3
					j = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = j;
				}
			}
		}
   

		//System.out.println("���� �� = "+Arrays.toString(arr));//�迭���� ��� ���� �޸����������� ���
     
////////////////////////////////////////////////////////////




/*
     System.out.println("���� �� = " + Arrays.toString(arr));
		int temp=0;
		 //�������Ĺ��.. : ���ʿ� ���� ���� �ּҰ��� ��ġ..
			for(int i=0;i< arr.length;i++){//9
				for(int j=(i+1);j<arr.length;j++){
					// i�� 0�϶� :  0 1 , 0 2, 0 3
					//i�� 1�ϴ� : 1 2 , 1 3 , 1 4 
					if(arr[i] > arr[j]){// 0 1 , 0 2, 0 3
						temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;		
					}
				}
			}//�ݺ����� 

         System.out.println("���� �� = "+Arrays.toString(arr));

*/
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}

		
	}
}