package sample04;

public class StudentController {

	private StudentService studentService;
	private Student student;

	public void setStudentService(StudentService studentService) {
		System.out.println("StudentController의 setStudentService(StudentService studentService)호출");
		this.studentService = studentService;
	}

	public void setStudent(Student student) {
		System.out.println("StudentController의 setStudent(Student student)호출");
		this.student = student;
	}

	public void insert() {
		// 서비스의 insert 호출
		studentService.insert(student);
	}

}
