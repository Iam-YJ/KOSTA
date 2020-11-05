package model.dto;

public class User {
	private int userNo;
	private String nickname;
	private int age;
	private String email;
	private String gender;
	private String grade;
	private int point;
	private String prefer;
	private int attend;
	private int usage;

	public User() {}
	
	public User( String nickname, String email, String prefer,int userNo) {
		
		this.nickname = nickname;
		this.email = email;
		this.prefer = prefer;
		this.userNo = userNo;
	}


	public User(int userNo, String nickname, int age, String email, String gender, String grade, int point,
			String prefer, int attend, int usage) {
		this.userNo = userNo;
		this.nickname = nickname;
		this.age = age;
		this.email = email;
		this.gender = gender;
		this.grade = grade;
		this.point = point;
		this.prefer = prefer;
		this.attend = attend;
		this.usage = usage;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getPrefer() {
		return prefer;
	}

	public void setPrefer(String prefer) {
		this.prefer = prefer;
	}

	public int getAttend() {
		return attend;
	}

	public void setAttend(int attend) {
		this.attend = attend;
	}

	public int getUsage() {
		return usage;
	}

	public void setUsage(int usage) {
		this.usage = usage;
	}
}
