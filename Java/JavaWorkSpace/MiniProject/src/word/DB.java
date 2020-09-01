
package word;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
//java.sql.어쩌구로 임포트 해야한다
import java.util.Set;

public class DB {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	Set<Word> Wordlist;

	public void readWord() {
		Wordlist = new HashSet<>();
		String sql = "select * from word";
		if (conn != null) {
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					String eng = rs.getString(1);
					String kor = rs.getString(2);
				//	Wordlist.add(new Word(eng, kor));
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @return the wordlist
	 */
	public Set<Word> getWordlist() {
		return Wordlist;
	}

	public void connectDB() {
		try {
			String user = "jin";
			String pw = "1234";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);

			// 주소 이름 비밀번호 일치하게
			if (conn != null) {
				System.out.println("DB 접속 성공 ");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 실패");
		} catch (SQLException e) {
			System.out.println("DB 접속 실패 ");
			e.printStackTrace();
		}
	} // 연결 테스트

	public void registerWord(String eng, String kor) { // db에 넣어주는 역할
//		Scanner scan = new Scanner(System.in);
//		System.out.print("삽입할 단어를 입력해 주세요: ");
//		String eng = scan.next();
//		System.out.print("단어의 뜻을 입력해 주세요(여러 뜻의 경우 /로 구분하세요): ");
//		String kor = scan.next();
		String sql = "insert into word (eng,kor) values(?,?)";
		if (conn != null) {
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, eng);
				pstmt.setString(2, kor);
				pstmt.executeUpdate();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}// 데이터 삽입 > 후에 heidi 가서 보면 데이터가 추가되어 있다.

	public void printDB() {
		String sql = "select * from word";
		if (conn != null) {
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					String eng = rs.getString(1);
					String kor = rs.getString(2);
					System.out.println(eng + "," + kor);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}// 데이터 리스트 획득

	public String select(String searchWord) {
		connectDB();
		String ret = "";
		Scanner scan = new Scanner(System.in);
		String sql = "select * from word where eng = ?";
		String sql2 = "select * from word where kor = ?";
		if (conn != null) {
			try {
				String a = searchWord;
				char c = a.charAt(0);
				if (c >= 'a' && c <= 'z') {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, a);
					System.out.println(searchWord);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						String eng = rs.getString(1);
						String kor = rs.getString(2);
						ret += (eng + "," + kor) + '\n';
					}
				} else {
					pstmt = conn.prepareStatement(sql2);
					pstmt.setString(1, a);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						String eng = rs.getString(1);
						String kor = rs.getString(2);
						ret += (eng + "," + kor) + '\n';
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // FIND
		closeDB();
		return ret;
	}

	public void closeDB() {
		try {
			pstmt.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // DB 연결 해제

	public void Run() {
		ReadFile rf = new ReadFile("words.txt");
		// TODO Auto-generated method stub
//		ReadFile readFile = new ReadFile("words.txt");
//		readFile.readFile();
		connectDB();
//		test.readWordAndRegister(readFile.getWords());
		// 한번 실행 후 주석처리 해야한다.
//		test.registerWord();
		// 이거하고 heidi에서 보면 데이터에 추가되어있다.
 
		//20 08 31 오류.. iterator가 false임 
		rf.readFile();
		Set<Word> words = rf.getWords();
		//System.out.println(words);
		Iterator iter = words.iterator(); // Iterator 사용
		//System.out.println(iter.hasNext());
		
		while (iter.hasNext()) {// 값이 있으면 true 없으면 false
			Word word = (Word) iter.next();
			registerWord(word.getWord(), word.returnString(word.getMean()));
		}

		readWord();
		printDB();

		closeDB();
	}

}
