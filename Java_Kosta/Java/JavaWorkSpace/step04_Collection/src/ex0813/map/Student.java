package ex0813.map;

public class Student extends Person {

	private int kor;
	private int eng;
	private int math;

	private int sum;

	public Student() {

	}

	public Student(String id, String name, int kor, int eng, int math) {
		super(id, name);
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}// id에 해당하는 사람의 국, 영, 수 성적을 수정할 것이다

	public Student(String id, String name, int age, int kor, int eng, int math) {
		super(id, name, age);
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
		this.sum  = kor+eng+ math;
	}// sum은 값을 받지 않고 직접 만들어서 사용할꺼다

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("kor=");
		builder.append(kor);
		builder.append(", eng=");
		builder.append(eng);
		builder.append(", math=");
		builder.append(math);
		builder.append(", sum=");
		builder.append(sum);
		return builder.toString();
	}

}
