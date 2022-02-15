
//view�� model ���̿��� �߰������� ���ִ� ������
//view���� ������ ��û�� ���� �׿� �ش��ϴ� service�� �ϰ�
//�� ȣ��� ����� �޾� ����� ������ �����ϴ� ������ �Ѵ� 
class ElectronicsController{
	private ElectronicsService service = ElectronicsService.getInstance(); 

	//���
	public void insert(Electronics electronics){
		//�𵨹�ȣ�� �ߺ����� üũ�� �� �ߺ��� �ƴϸ� ����Ѵ�.

		if(service.searchByModelNo(electronics.getModelNo()) != null){
			EndView.printMessage(electronics.getModelNo()+"�ߺ��Դϴ�. ����� �� �����ϴ�");
			return;
		}

		boolean result = service.insert(electronics);
		if(result){
			EndView.printMessage("��ϵǾ����ϴ�");
		}else{
			EndView.printMessage("��ϵ��� �ʾҽ��ϴ�");
			
		
		}
	}

	//��ü�˻�
	public void selectAll(){
		Electronics[] elecArr = service.selectAll();
		EndView.printAll(elecArr);
	}

	//�۹�ȣ �˻�
	public void searchByModelNo(int modelNo){
		Electronics electronics = service.searchByModelNo(modelNo);
		if(electronics == null){
			EndView.printMessage(modelNo+"�� �������� �ʾ� �˻��� �� �����ϴ�");
		}else{
			EndView.printSearchByModelNo(electronics);
		}
	}

	//�����ϱ�
	public void update(Electronics electronics){
		if(service.update(electronics) ){
			EndView.printMessage("�����Ǿ����ϴ�");
		}else{
			EndView.printMessage("�������� �ʾҽ��ϴ�");
		
		}
	
	}


}