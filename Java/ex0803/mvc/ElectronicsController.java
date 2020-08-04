
//view와 model 사이에서 중간역할을 해주는 것으로
//view에서 들어오는 요청을 받을 그에 해당하는 service를 하고
//그 호출된 결과를 받아 결과뷰 쪽으로 전달하는 역할을 한다 
class ElectronicsController{
	private ElectronicsService service = ElectronicsService.getInstance(); 

	//등록
	public void insert(Electronics electronics){
		boolean result = service.insert(electronics);
		if(result){
			EndView.printMessage("등록되었습니다");
		}else{
			EndView.printMessage("등록되지 않았습니다");
			
		}
	}

	//전체검색

	//글번호 검색

	//수정하기


}