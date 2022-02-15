import java.util.Scanner;

public class MenuView {
   Scanner sc = new Scanner(System.in);//Ű�����Է� �غ�
   SingController controller = new SingController();
    /**
	  �޴��� ����ϴ� �޼ҵ�
	*/
    public void printMenu(){
	   while(true){
		 System.out.println();
		 System.out.println("========== �޴��� �������ּ��� ==========");
		 System.out.println("1.��ü���  2.�뷡�߰�  3.�뷡���� 4.�뷡���� 5. �κа˻� 6. ����");
         int no = sc.nextInt();
		 switch(no){
			 case 1:	controller.selectAll() ;  break;
             case 2:	this.inputInsert() ; break;
			 case 3:	inputUpdate(); break; //����
			 case 4:	deleteSing(); break; //����
			 case 5:	searchTitle(); break; //����˻� searchTitle
			 //case 6:	Reverse(); break; //�����˻� searchSinger
			 case 6:   
				 System.out.println("��� ���α׷� �����մϴ�...");
				 System.exit(0) ; //���α׷���������
			 break;
			 default: System.out.println("�߸��� ���ù�ȣ�Դϴ�. �ٽ��Է����ּ���!");

		 }//switch����
	   }//while����  	
	}
	 
	/**
	  ����Ҷ� �ʿ��� ���� �Է� �޴� �޼ҵ�
	*/
	public  void inputInsert(){
       System.out.print("�뷡���� ? ");
	   int singRank = sc.nextInt();

	   System.out.print("�뷡���� ? ");
	   String singTitle = sc.next();

	   System.out.print("���� ? ");
	   String singSinger = sc.next();

        // �Էµ� ���� 4���� �ϳ��� Electronics��ü�� �����.
         Sing sing = 
			 new Sing(singRank, singTitle, singSinger);

         controller.insert(sing);
	}

	/**
	  �κа˻��� �ʿ��� ���� �Է¹޴� �޼ҵ�
	*/
	/*
	public  void inputSearch(){
        System.out.print("�˻��� ����?");
		int singRank = sc.nextInt();
		controller.searchByModelNo(singRank);
	}
	*/

	/**
	  �����Ҷ� �ʿ��� ���� �Է� �޴� �޼ҵ�
	  ( �𵨹�ȣ�� �ش��ϴ� ������ǰ �𵨰���, ���� ���� �ϱ�) 
	*/
    public void inputUpdate(){
      System.out.print("������ �뷡 ������ ? ");
	  int singRank = sc.nextInt();

	   System.out.print("������ �뷡������? ? ");
	   String singTitle = sc.next();
		
		System.out.print("������ ������ ? ");
	   String singSinger = sc.next();


       Sing sing = 
			 new Sing(singRank, singTitle, singSinger);

         controller.update(sing);
	}

	//4�� �����ϱ�
	public void deleteSing(){
	System.out.print("������ �뷡�� ������ ? ");
	 int singRank = sc.nextInt();

	 controller.searchByModelNo(singRank);
	 

	}

//5�� ���� ã��
	public void searchTitle(){
	System.out.print("ã����� �뷡�� ������ ? ");
	 int singRank = sc.nextInt();

	 controller.searchByModelNo2(singRank);
	}




//6�� ���� ã��
	public void searchSinger(){
	System.out.print("ã����� ������ ������ ? ");
	 int singRank = sc.nextInt();

	}



}
