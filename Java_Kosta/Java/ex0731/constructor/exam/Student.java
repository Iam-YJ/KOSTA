
//�л��� �̸�, ���� �ּҸ� ����(����, ��ȸ)
// :�Ӽ��� �����ϴ� ��ü�� VO = DTO = Domain ��ü��� �θ���
// :�Ӽ��� �ܺηκ��� �����͸� ��ȣ�ϱ� ���ؼ� ����
//   -> �� ��ȿ���� ���� ������ ���� ��ȸ�ǰų� ������� ���ϵ��� 
//       �ݵ�� �־��� �޼ҵ带 ���ؼ����� ������ �� �ֵ����Ѵ�.
class Student{
	private String name;
	private int age;
	private String addr;

//�μ� ���� �⺻ �����ڸ� ����� �����ε��ϴ� ���� ������
// -> ��ӽÿ� �⺻�����ڰ� ������ ����� �� �� ����.
Student(){}



	//������ �����
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







