//학생의 정보(전체검색, 부분검색, 수정, 삭제,,,,,)

class StudentService{

	Student [] stdArr = new Student [5];


//학생의 정보를 추가
//5명
public void insert(){

	for(int i=0; i<stdArr.length; i++){
		stdArr[i] = this.create((String)("유진"+i),25,"서울");	
	}

	
}

//객체를 생성해서 값을 변경하고 생성된 객체를 리턴하는 메소드 작성
private Student create(String name, int age, String addr){
	Student st = new Student();
	st.setName(name);
	st.setAge(age);
	st.setAddr(addr);

	return st;
}

//모든 학생의 정보를 검색
public void selectAll(){
	System.out.println("***모든 학생의 정보 " + stdArr.length + "명***");
	for(int i = 0; i<stdArr.length; i++){
		System.out.print("이름 : " + stdArr[i].getName() + "\t");
		System.out.print("나이 : " + stdArr[i].getAge() + "\t");
		System.out.print("주소 : " + stdArr[i].getAddr() + "\t");
		System.out.println();
	}

	System.out.println("***개선된 for로 출력 ***");
	for(Student s : stdArr){
		System.out.print("이름 : " + s.getName() + "\t");
		System.out.print("나이 : " + s.getAge() + "\t");
		System.out.print("주소 : " + s.getAddr() + "\t");
		System.out.println();
	} 



}


//이름에 해당하는 학생의 정보를 검색
public void searchBy(String name){
	
	
	for (Student st : stdArr){
		if(st.getName().equals(name)){
			System.out.println("========찾았다========");
			System.out.println(st.getName() + " 님 나이는"+st.getAge()+"살, 주소는 "+st.getAddr()+"입니다");
			System.out.println();

			//break; //for문을 빠져나가라
			return; //함수를 빠져나가라(SearchByName을 나간다)
			//			-> 찾으면 출력하고 메인으로 간다 
		}
	}System.out.println(name+"님 정보는 없습니다");
	System.out.println();



}

}