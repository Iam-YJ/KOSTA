//TwoDmArrayExam.java

class TwoDmArray{
	//String�� �����ϴ� twoDmArray �迭����
	String [][] twoDmArray = new String [10][];
	
	//�޼ҵ� make2DmArray
	//twoDmArray �迭��  ���� �Ҵ�
	public void make2DmArray(){
		for(int i=0; i<twoDmArray.length; i++){
			twoDmArray[i] = new String[twoDmArray.length];
			for(int j=0; j<twoDmArray[i].length; j++){
				twoDmArray[i][j] = (i+1)+"��"+(j+1)+"ȣ";
			}
		}
	}

		
	//�޼ҵ� print2DmArray
	//	twoDmArray �迭�� ���� �־����������� ���
	public void print2DmArray(){
		for(int i=0; i<twoDmArray.length; i++){
			for(int j=0; j<i; j++){
				System.out.print(""+"\t");
			}for(int k=i; k<10; k++){
				System.out.print(twoDmArray[k][i]+"\t");
			}
			System.out.println();
		}
	}		
}

public class TwoDmArrayExam{
	//main�޼ҵ忡��
	public static void main(String [] args){
		//TwoDmArray��ü����
		TwoDmArray tda = new TwoDmArray();
		//TwoDmArray��ü�� make2DmArray�޼ҵ� ȣ��
		tda.make2DmArray();
		//TwoDmArray��ü�� print2DmArray�޼ҵ� ȣ��
		tda.print2DmArray();

	
	}
	
		
	
}
