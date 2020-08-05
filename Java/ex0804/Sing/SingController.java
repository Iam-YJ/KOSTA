
//view와 model 사이에서 중간역할을 해주는 것으로
//view에서 들어오는 요청을 받을 그에 해당하는 service를 하고
//그 호출된 결과를 받아 결과뷰 쪽으로 전달하는 역할을 한다 
class SingController{
	private SingService service = SingService.getInstance(); 

	//등록
	public void insert(Sing sing){
		//모델번호가 중복인지 체크한 후 중복이 아니면 등록한다.

		if(service.searchByModelNo(sing.getSingRank()) != null){
			EndView.printMessage(sing.getSingRank()+"중복입니다. 등록할 수 없습니다");
			return;
		}

		boolean result = service.insert(sing);
		if(result){
			EndView.printMessage("등록되었습니다");
		}else{
			EndView.printMessage("등록되지 않았습니다");
	
		}
	}

	//전체검색
	public void selectAll(){
		Sing[] sArr = service.selectAll();
		EndView.printAll(sArr);
	}

	//글번호 검색
	public void searchByModelNo(int singRank){
		Sing sing = service.searchByModelNo(singRank);
		if(sing == null){
			EndView.printMessage(singRank+"는 존재하지 않아 삭제할 수 없습니다");
		}else{
			sing.setSingRank(0);
			sing.setSingTitle(null);
			sing.setSingSinger(null);
			EndView.printSearchByModelNo(sing);
		}
	} 
	
	//순위 검색 -> 노래 검색 위해
	public void searchByModelNo2(int singRank){
		Sing sing = service.searchByModelNo(singRank);
		if(sing == null){
			EndView.printMessage(singRank+"는 존재하지 않아 검색할 수 없습니다");
		}else{
			EndView.printSearchByModelTitle(sing);
		}
	}

	//순위 검색 -> 가수 검색 위해 
	public void searchByModelNo3(int singRank){
		Sing sing = service.searchByModelNo(singRank);
		if(sing == null){
			EndView.printMessage(singRank+"는 존재하지 않아 검색할 수 없습니다");
		}else{
			EndView.printSearchByModelSinger(sing);
		}
	}

	//수정하기
	public void update(Sing sing){
		if(service.update(sing) ){
			EndView.printMessage("수정되었습니다");
		}else{
			EndView.printMessage("수정되지 않았습니다");
		
		}
	
	}
	


}