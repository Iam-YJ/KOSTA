package ch04;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.Statement;

public class JdbcEx3 {

	public static void main(String[] args) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		String user = "jin", pw = "1234";

		Connection con = DriverManager.getConnection(url, user, pw);

		System.out.println("접속 성공!!!");

		Statement st = con.createStatement();

		// statement 객체를 얻어 온다

		String sql = "select * from word";

		// order by no : no칼럼으로 오름차순 정렬

		ResultSet rs = st.executeQuery(sql); // select문 일경우에는 executeQuery 사용

		// insert문 경우 executeUpdate 사용

		// 현재 rs에는 칼럼이 1~**까지 들어있다

		while (rs.next()) { //

			// rs.next() 해당 내용을 행단위로 하나씩 가져올수 있는 객체



			String kor = rs.getString("kor");

			String eng = rs.getString("eng");

			System.out.println(eng + " : " + kor);

		}

		if (rs != null)
			rs.close();

		if (st != null)
			st.close();

		if (con != null)
			con.close();

	}

}