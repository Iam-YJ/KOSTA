//�л��� ����(��ü�˻�, �κа˻�, ����, ����,,,,,)

class StudentService{

	Student [] stdArr = new Student [5];


//�л��� ������ �߰�
//5��
public void insert(){

	for(int i=0; i<stdArr.length; i++){
		stdArr[i] = this.create((String)("����"+i),25,"����");	
	}

	
}

//��ü�� �����ؼ� ���� �����ϰ� ������ ��ü�� �����ϴ� �޼ҵ� �ۼ�
private Student create(String name, int age, String addr){
	Student st = new Student();
	st.setName(name);
	st.setAge(age);
	st.setAddr(addr);

	return st;
}

//��� �л��� ������ �˻�
public void selectAll(){
	System.out.println("***��� �л��� ���� " + stdArr.length + "��***");
	for(int i = 0; i<stdArr.length; i++){
		System.out.print("�̸� : " + stdArr[i].getName() + "\t");
		System.out.print("���� : " + stdArr[i].getAge() + "\t");
		System.out.print("�ּ� : " + stdArr[i].getAddr() + "\t");
		System.out.println();
	}

	System.out.println("***������ for�� ��� ***");
	for(Student s : stdArr){
		System.out.print("�̸� : " + s.getName() + "\t");
		System.out.print("���� : " + s.getAge() + "\t");
		System.out.print("�ּ� : " + s.getAddr() + "\t");
		System.out.println();
	} 



}


//�̸��� �ش��ϴ� �л��� ������ �˻�
public void searchBy(String name){
	
	
	for (Student st : stdArr){
		if(st.getName().equals(name)){
			System.out.println("========ã�Ҵ�========");
			System.out.println(st.getName() + " �� ���̴�"+st.getAge()+"��, �ּҴ� "+st.getAddr()+"�Դϴ�");
			System.out.println();

			//break; //for���� ����������
			return; //�Լ��� ����������(SearchByName�� ������)
			//			-> ã���� ����ϰ� �������� ���� 
		}
	}System.out.println(name+"�� ������ �����ϴ�");
	System.out.println();



}

}