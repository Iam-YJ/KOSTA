package sample04;

public class StudentServiceImpl implements StudentService {
	private StudentDAO studentDAO;

	
	public void setStudentDAO(StudentDAO studentDAO) {
		System.out.println("setStudentDAO(StudentDAO studentDAO) 호출됨");
		this.studentDAO = studentDAO;
	}
	
	public void insert(Student student) {
		System.out.println("StudentServiceImpl의 insert 호출됨");
		//dao의 insert 호출
		studentDAO.insert(student);

	}

}
