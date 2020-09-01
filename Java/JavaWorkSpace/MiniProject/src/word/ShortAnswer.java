
package word;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JTextArea;

public class ShortAnswer {

	Set<Word> arraylist;
	String sql = "select * from word";
	boolean waitForAnswer = true;

//	MyFrame mf;
	
	JTextArea textOutputArea;

	public ShortAnswer(Set<Word> wordslist, MyFrame mf) {
		this.arraylist = wordslist;
		//this.mf = mf;
	}

	public void shortAnswer() {
		Scanner scan = new Scanner(System.in);
		Random randomGenerator = new Random();
		// 문제 중복을 검사하기 위한 배열
		int rand[] = new int[5];
		// 정답 개수 저장하는 변수
		int count = 0;
		for (int i = 0; i < 5; i++) {
			int r = randomGenerator.nextInt(arraylist.size());
			rand[i] = r;
			// 문제 중복 검사
			int j = 0;
			while (j < i) {
				if (rand[i] == rand[j]) {
					j = 0;
					rand[i] = randomGenerator.nextInt(arraylist.size());
					continue;
				}
				j++;
			}

			Iterator<Word> it = arraylist.iterator();
			for (int k = 0; k < rand[i]; k++) {
				it.next();
			}
			Word testword = (Word) it.next();
//			mf.textOutputArea.setText("hi");
			//mf.textOutputArea.append(testword.getWord() + "의 뜻은 무엇인가요? : ");

			// System.out.print(testword.getWord() + "의 뜻은 무엇인가요? : ");

			String answer = scan.nextLine();
//			// 정답인지 판별하는 변수

			boolean isCorrect = false;
			for (String mean : testword.getMean()) {
				if (answer.equals(mean)) {
					System.out.println("정답입니다.");
					count++;
					isCorrect = true;
					break;
				}
			}
			if (!isCorrect) {
				System.out.println("오답입니다.");

			}
			waitForAnswer = true;
		}
		System.out.println("정답 개수 : " + count + " / 정답률 : " + (count * 100 / 5) + "%");

	}

}
