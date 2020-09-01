package word;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class WordMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		ReadFile file = new ReadFile("words.txt");
		file.readFile();
		Set<Word> wordlist = file.getWords();
		String sql = "select * from word";
		DBConnection db = new DBConnection();
		db.Run();
		wordlist = db.getWordlist();
		MyFrame frame = new MyFrame("잊혀질 단어장");
		while (true) {
			try {
				switch (scan.nextInt()) {
	
					
				case 1:
					ShortAnswer shortanswer = new ShortAnswer(wordlist);
					shortanswer.shortAnswer();
					break;
				case 2:
					LongAnswer longanswer = new LongAnswer(wordlist);
					longanswer.longAnswer();
					break;
					
				default:
					System.out.println("잘못된 입력입니다.");
					break;
				}
			} catch (InputMismatchException e) {// 숫자가 아닌값을 입력했을때
				// Scanner 버그를 잡기위한 코드. Scanner instance 초기화
				// 초기화하지 않으면 무한루프 발생
				scan = new Scanner(System.in);
				System.out.println("잘못된 입력입니다. 숫자로 입력해주세요.");
			}
		}

	}

}
