
//학생의 이름, 나이 주소를 관리(변경, 조회)
// :속성을 관리하는 객체를 VO = DTO = Domain 객체라고 부른다
// :속성을 외부로부터 데이터를 보호하기 위해서 은닉
//   -> 즉 유효하지 않은 데이터 값이 조회되거나 변경되지 못하도록 
//       반드시 주어진 메소드를 통해섬나이 접근할 수 있도록한다.
class Student{
	private String name;
	private int age;
	private String addr;

//인수 없는 기본 생성자를 만들고 오버로딩하는 것을 권장함
// -> 상속시에 기본생성자가 없으면 상속을 할 수 없다.
Student(){}



	//생성자 만들기
Student(String name, int age, String addr){
	this.name = name;
	this.age = age;
	this.addr = addr;

}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setAge(int age){
		this.age = age;
	}

	public int getAge(){
		return age;
	}

	public void setAddr(String addr){
		this.addr = addr;
	}

	public String getAddr(){
		return addr;
	}
}







