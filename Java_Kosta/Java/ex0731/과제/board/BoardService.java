class BoardService 
{
	Board [] boardArr = new Board[10]; //�ִ� 10������ ���� ���� 
	int count;

	//�ʱ�ġ ������ �����ϴ� ������ �ۼ�
	BoardService(String [][] data){ //�����ڴ� //String [][] data = data;
	//5���� ������ �ְ� �Ҳ��� -> Board Ŭ������ �μ� 4���޴� ��
		
	//5���� ������ �迭�ֱ�	
		for(int i=0; i<data.length; i++){
	
			boardArr[i] = this.create(data[i]); //1���� �迭�� ������ create ȣ��
			//boardArr[i]��°�� Board �迭�� ���� 
			count ++;
		}
	}


	//������ Board ��ü�� �����ؼ� �������ִ� �޼ҵ�
	private Board create(String [] row){ //{"1","java����","������","�ʹ���մ�"}
		return new Board(Integer.parseInt(row[0]),row[1],row[2], row[3]);
	
	}

	//��ϸ޼ҵ�
	// : �߰����� �迭�濡 board�� ���� �� �ִ��� üũ�ϰ� 
	// : ������ " �� �̻� �߰��� �� �����ϴ�" / ������ �߰��Ѵ� 
	public void insert(Board board){
		if(count == boardArr.length){
			System.out.println("���̻� �߰��� �� �����ϴ�.");
			return; //�Լ��� ���������� 
		}
		boardArr[count++] = board;
		
	}


	//��ü�˻� - ��ü ��� �޼ҵ�
	public void selectAll(){
		System.out.println("******�Խù� List ("+count+") ��");
		for(int i = 0; i<count; i++){
			System.out.print("no :" + boardArr[i].getNo() + "\t");
			System.out.print("subject :" + boardArr[i].getSubject() + "\t");
			System.out.print("writer :" + boardArr[i].getWriter() + "\t");
			System.out.print("content :" + boardArr[i].getContent() + "\n");

		}
	
	}


	//�κа˻�(�۹�ȣ�� �ش��ϴ� �Խù� �˻�
	//			-> �۹�ȣ ������ "�۹�ȣ ���� �ۼ��� ����" ���
	//			->        ������ "�۹�ȣ�� �������� �ʽ��ϴ�" ���

	public void searchByNo(int no){
		for(int i=0; i< count; i++){
			Board board = boardArr[i];
			if(board.getNo() == no){
				System.out.print("���� �����մϴ�");
				System.out.print("no :" + boardArr[i].getNo() + "\t");
				System.out.print("subject :" + boardArr[i].getSubject() + "\t");
				System.out.print("writer :" + boardArr[i].getWriter() + "\t");
				System.out.print("content :" + boardArr[i].getContent() + "\n");
				return; //�Լ��� ��������

			}
		}System.out.print("���� �������� �ʽ��ϴ�");
	
	}


	//����
	//�۹�ȣ�� �ش��ϴ� �ۼ��ڿ� ���븸 ���� 
	//  : �̰�� �μ� 3���޴� �����ڸ� �̿��ؼ� �޴´�
	//  : �۹�ȣ�� �ش��ϴ� ������ ������ 
	//    -> �� �۹�ȣ�� �ش��ϴ� �ۼ���, ������ ���޹��� ������ ����
	//    -> ������ "�۹�ȣ ������ ������ �� �����ϴ�" 
	public void update(Board board){
		for(int i=0; i<count; i++){
			Board dbBoard = boardArr[i];
			
			if(dbBoard.getNo() == board.getNo()){
				//������ ����
				dbBoard.setNo(board.getNo());  
				dbBoard.setWriter(board.getWriter());
				dbBoard.setWriter(board.getContent());

				return;
			}
		}//�۹�ȣ ���� ����
		System.out.println(board.getNo() + "�� �۹�ȣ ������ ������ �� �����ϴ�");
		
	
	}


}
