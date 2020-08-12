package ex0812.set;

public class Member {

	private String name;
	private int age;

	public Member() {

	}

	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {

		return name.hashCode();
	}

	public boolean eqauls(Object obj) {
		if (obj instanceof Member) {
			Member member = (Member) obj;
			//다운캐스팅
			if (name.equals(member.getName())) {
				return true;
			}
		}
		return false;

	}

}
