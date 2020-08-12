package lotto;

import java.util.ArrayList;
import java.util.*;

public class Lotto {

	List<Integer> list = new ArrayList<Integer>(6);
	static int cnt = 0;

	public Lotto() {

	}

	public void createLottoNo() {
		while (list.size() < 6) {// 1
			Random r = new Random();
			int lottoNo = r.nextInt(45) + 1;

			if (!list.contains(lottoNo)) {
				list.add(lottoNo);
			}
		}
		Collections.sort(list);

		System.out.println(list);
		// list.toString() 되어있음
		// println은 객체를 만나면 toString()이 자동으로 호출
	}

	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		lotto.createLottoNo();

	}

}
