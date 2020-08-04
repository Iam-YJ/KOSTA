//전자제품을 관리하는 클래스(등록, 수정, 검색,,,)
//	:싱글톤 클래스로 만든다


class ElectronicsService{

	private static ElectronicsService instance = new ElectronicsService();
	private Electronics [] elecArr = new Electronics [10];

	public static int count; //현재 배열에 몇개의 Electronics가 저장되었는지 체크하는 변수 

	//전자제품 초기치 데이터
	String [][] data = new String [][] {
		{"1", "에어컨","350000", "무풍 에어컨 짱 시원"},
		{"2", "세탁기","325000", "LG 세탁기"},
		{"3", "건조기","530000", "건조해요"},
		{"4", "선풍기","380000", "바람 불어요"},
		{"5", "전자렌지","150000", "전자렌지 짱 "},
		
	};

	//외부에서 객체생성안됨 
	//전자제품 초기피 데이터 세팅 기능 작성
	private ElectronicsService(){
		for(int i=0; i<data.length; i++){
		elecArr[count++] = new Electronics(Integer.parseInt(data[i][0]), data[i][1],Integer.parseInt(data[i][2]), data[i][3]);
		}	
	}
	//현재객체를 리턴해주는 메소드 제공
	public static ElectronicsService getInstance(){
		return instance;
	}
	
	//selectAll(전체검색) - 출력 정보들을 가지고 나가야한다 return Electronics[]
	public Electronics[] selectAll(){
		return elecArr;
	}

	//insert(등록하기) - 인수:Electronics, 리턴:boolean(성공, 실패여부)
	//true - 등록성공 // false - 등록실패
	public boolean insert(Electronics electronics){
		if(elecArr.length == count){
			return false;
		}
		elecArr[count++] = electronics;
		return true;
	}

	//searchByModelNo(모델 번호에 해당하는 제품 검색하기) - 번호로 찾기 return Electronics
	public Electronics searchByNo(int modelNo){
		for(int i=0; i<ElectronicsService.count; i++){
			if(elecArr[i].getModelNo() == modelNo){
				return elecArr[i];
			}
		}return null; //못찾았다 
	}

	//update(모델 번호에 해당하는 제품 수정하기 (설명만 수정하기))
	public boolean update(Electronics electronics){
		Electronics searchElec = this.searchByNo(electronics.getModelNo());
		if(searchEelec == null) return false;

		// 찾았다 -> 수정해주자
		searchElec.setModelDetail(electronics.getModelDetail());
		return true;

	}


}