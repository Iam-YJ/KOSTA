package word;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ReadFile {
	private File file;
	private Set<Word> words = new HashSet<>();
	
	public ReadFile(String filename) {
		file = new File(filename);
		System.out.println(file);
	}
	
	public void readFile() {
		try {
			Scanner scan = new Scanner(file, "UTF-8");
			while(scan.hasNextLine()) {
				String str = scan.nextLine();
				words.add(new Word(str));
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일이 존재하지 않습니다.");
			System.out.println("파일 이름을 확인해주세요.");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Set<Word> getWords() {
		return words;
	}
	
	/*public void printword() {
		for(int i=0;i<words.size();i++)
		{
			System.out.println(words.get(i).getWord());
			List<String> means = words.get(i).getMean();
			for(int j=0; j<means.size(); j++) {
				System.out.println(means.get(j));
			}
		}
	}*/

}