class RandomQuiz1{
	public static void main(String args[]){

/* 1~10������ ������ �߻�
�߻��� ������ 1�̸� �Ͽ���
2�̸� ������
3�̸� ȭ 4 �� 5 �� 6�� �̿��� ���̸� ����� ��� */

	int day = (int)(Math.random()*10)+1;
		//System.out.println(day);
		if(day==1){
		System.out.println(day+":�Ͽ���");
		}else if(day==2){
		System.out.println(day+":������");
		}else if(day==3){
		System.out.println(day+":ȭ����");
		}else if(day==4){
		System.out.println(day+":������");
		}else if(day==5){
		System.out.println(day+":�����");
		}else if(day==6){
		System.out.println(day+":�ݿ���");
		}else{
		System.out.println(day+":�����");
		}
  }
}