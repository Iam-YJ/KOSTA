package word;

import java.util.Random;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class LongAnswer {

	Set<Word> arraylist;

	public LongAnswer(Set<Word> words) {
		this.arraylist = words;
	}

	public void longAnswer() {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		System.out.println("객관식 시험을 시작하겠습니다.");

		int a, r;
		int rand[] = new int[5]; // 문제 중복을 검사하기 위한 배열
		int num[] = new int[4]; // 보기에 넣을 랜덤한 4가지를 저장하는 배열
		boolean check1[] = new boolean[arraylist.size()]; // 문제 배열에 숫자가 중복으로 들어갔는지 확인하는 배열
		boolean check2[] = new boolean[arraylist.size()]; // 보기 배열에 숫자가 중복으로 들어갔는지 확인하는 배열

		int count = 0; // 정답 개수 저장하는 변수

		for (int i = 0; i < arraylist.size(); i++) // 배열 초기화
			check1[i] = false;

		for (int i = 0; i < 5; i++) {

			for (int j = 0; j < arraylist.size(); j++) // 배열 초기화
				check2[j] = false;

			while (true) // 출제 문제 중복 안 되게 뽑기
			{
				r = random.nextInt(arraylist.size());
				if (!check1[r]) // 만약에 문제가 없으면, 이 문제 출제.
				{
					rand[i] = r;
					check1[r] = true;
					break;
				}
				else
					continue;
			}

			Iterator<Word> it = arraylist.iterator();
			for(int j=0; j<rand[i]; j++) {
				it.next();
			}
			Word testword = (Word) it.next();
			testword.setCount(testword.getCount()+1);
			System.out.println("출제된 횟수"+testword.getCount());
			System.out.println(testword.getWord() + "의 뜻은 무엇인가요?");

			
			
			check2[rand[i]] = true;

			int k = 0;
			while (k < 4) // 보기 채우기
			{
				r = random.nextInt(arraylist.size());
				if (!check2[r]) {
					num[k] = r;
					check2[r] = true;
					k++;
				} 
				else
					continue;
			}

			a = random.nextInt(4); // 보기에 정답 넣어주기
			num[a] = rand[i];

			// 보기 제시
			for (int j = 0; j < 4; j++) 
			{
				System.out.print((j + 1) + ". ");
				it = arraylist.iterator();
				for(int m = 0; m<num[j]; m++) {
					it.next();
				}
				Word example = (Word) it.next();
				for (String mean : example.getMean())
					System.out.print(mean +"/ ");
				System.out.println();
				
			}
				System.out.print("정답: ");
				int answer = scan.nextInt();

				
				// 정답을 맞췄는지 판별하는 변수
				boolean isCorrect = false;
				if (answer == a + 1) {
					System.out.println("정답입니다.");
					count++;
					isCorrect = true;
				}
				if (!isCorrect)
					System.out.println("오답입니다.");
			}
			System.out.println("정답 개수 : " + count + " / 정답률 : " + (count * 100 / 5) + "%");
		}
}
