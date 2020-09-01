package word;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Word {
	private String word;
	private List<String> mean = new ArrayList<>();
	private int count;

//	public Word(String word) {
//		// 영단어와 뜻 분리
//		StringTokenizer st = new StringTokenizer(word, ":");
//		// 앞뒤에 있는 공백문자 제거 후 저장
//		this.word = st.nextToken().trim();
//		// 뜻이 여러개 일 결우 각각 분리
//		StringTokenizer token = new StringTokenizer(st.nextToken(), "/");
//		while (token.hasMoreTokens()) {
//			this.mean.add(token.nextToken().trim());
//		}
//
//	}

	// 20 08 31 추가함
	public String returnString(List<String> ls) {
		String str = "";
		//Iterator<String> itr = mean.iterator();
		
//Iterator<String> itr = ls.iterator();
		
//		while (itr.hasNext()) {
//			str += ((Iterator<String>) ls).next();
//		}
		
		 for (int index = 0; index < ls.size() ; index++) {
			   //System.out.println(arra​yList.get(index));
			   str += ls.get(index);
			  }

		return str;
	}

//	public Word(String word, String mean) {
//		this.word = word;
//		StringTokenizer token = new StringTokenizer(mean, "/");
//		while (token.hasMoreTokens()) {
//			this.mean.add(token.nextToken().trim());
//		}
//
//	}

	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	public String getWord() {
		return word;
	}

	public int getCount() {
		return count;
	}

	public List<String> getMean() {
		return mean;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Word) {
			Word word = (Word) obj;
			if (word.word.equals(this.word))
				return true;
			else
				return false;
		} else
			return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		// 영어 단어가 같으면 뜻과 상관없이 중복
		// 뜻만 다른 단어가 들어갈 경우 문제 출제시 정답을 입력했음에도 오답 처리가 될 수 있음
		return this.word.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.word + " : " + this.mean;
	}

}
