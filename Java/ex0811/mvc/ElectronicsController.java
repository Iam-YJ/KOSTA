
//view와 model 사이에서 중간역할을 해주는 것으로
//view에서 들어오는 요청을 받을 그에 해당하는 service를 하고
//그 호출된 결과를 받아 결과뷰 쪽으로 전달하는 역할을 한다 
class ElectronicsController{
	private ElectronicsService service = ElectronicsService.getInstance(); 

	//등록
	public void insert(Electronics electronics){
		//모델번호가 중복인지 체크한 후 중복이 아니면 등록한다.

		if(service.searchByModelNo(electronics.getModelNo()) != null){
			EndView.printMessage(electronics.getModelNo()+"중복입니다. 등록할 수 없습니다");
			return;
		}

		boolean result = service.insert(electronics);
		if(result){
			EndView.printMessage("등록되었습니다");
		}else{
			EndView.printMessage("등록되지 않았습니다");
			
		
		}
	}

	//전체검색
	public void selectAll(){
		Electronics[] elecArr = service.selectAll();
		EndView.printAll(elecArr);
	}

	//글번호 검색
	public void searchByModelNo(int modelNo){
		Electronics electronics = service.searchByModelNo(modelNo);
		if(electronics == null){
			EndView.printMessage(modelNo+"는 존재하지 않아 검색할 수 없습니다");
		}else{
			EndView.printSearchByModelNo(electronics);
		}
	}

	//수정하기
	public void update(Electronics electronics){
		if(service.update(electronics) ){
			EndView.printMessage("수정되었습니다");
		}else{
			EndView.printMessage("수정되지 않았습니다");
		
		}
	
	}


}