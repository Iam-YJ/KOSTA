
//view�� model ���̿��� �߰������� ���ִ� ������
//view���� ������ ��û�� ���� �׿� �ش��ϴ� service�� �ϰ�
//�� ȣ��� ����� �޾� ����� ������ �����ϴ� ������ �Ѵ� 
class SingController{
	private SingService service = SingService.getInstance(); 

	//���
	public void insert(Sing sing){
		//�𵨹�ȣ�� �ߺ����� üũ�� �� �ߺ��� �ƴϸ� ����Ѵ�.

		if(service.searchByModelNo(sing.getSingRank()) != null){
			EndView.printMessage(sing.getSingRank()+"�ߺ��Դϴ�. ����� �� �����ϴ�");
			return;
		}

		boolean result = service.insert(sing);
		if(result){
			EndView.printMessage("��ϵǾ����ϴ�");
		}else{
			EndView.printMessage("��ϵ��� �ʾҽ��ϴ�");
	
		}
	}

	//��ü�˻�
	public void selectAll(){
		Sing[] sArr = service.selectAll();
		EndView.printAll(sArr);
	}

	//�۹�ȣ �˻�
	public void searchByModelNo(int singRank){
		Sing sing = service.searchByModelNo(singRank);
		if(sing == null){
			EndView.printMessage(singRank+"�� �������� �ʾ� ������ �� �����ϴ�");
		}else{
			sing.setSingRank(0);
			sing.setSingTitle(null);
			sing.setSingSinger(null);
			EndView.printSearchByModelNo(sing);
		}
	} 
	
	//���� �˻� -> �뷡 �˻� ����
	public void searchByModelNo2(int singRank){
		Sing sing = service.searchByModelNo(singRank);
		if(sing == null){
			EndView.printMessage(singRank+"�� �������� �ʾ� �˻��� �� �����ϴ�");
		}else{
			EndView.printSearchByModelTitle(sing);
		}
	}

	//���� �˻� -> ���� �˻� ���� 
	public void searchByModelNo3(int singRank){
		Sing sing = service.searchByModelNo(singRank);
		if(sing == null){
			EndView.printMessage(singRank+"�� �������� �ʾ� �˻��� �� �����ϴ�");
		}else{
			EndView.printSearchByModelSinger(sing);
		}
	}

	//�����ϱ�
	public void update(Sing sing){
		if(service.update(sing) ){
			EndView.printMessage("�����Ǿ����ϴ�");
		}else{
			EndView.printMessage("�������� �ʾҽ��ϴ�");
		
		}
	
	}
	


}