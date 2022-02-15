

import java.io.File;
import java.sql.Date;

import javax.swing.JOptionPane;

public class FileExam {

	public FileExam() throws Exception {
		String fileName = JOptionPane.showInputDialog("파일 이름은?");
//		System.out.println(fileName);
		File file = new File(fileName);
		if (file.exists()) {
			System.out.println(fileName + "은 있습니다.");
			if (file.isFile()) {
				System.out.println("*****" + fileName + "의 정보 ******");
				System.out.println("읽기기능 : " + file.canRead());
				System.out.println("쓰기기능 : " + file.canWrite());
				System.out.println("절대경로 : " + file.getAbsolutePath());
				System.out.println("파일이름 : " + file.getName());
				System.out.println("파일용량(byte) : " + file.length());
				System.out.println("마지막 수정일  : " + file.lastModified());
				
				System.out.println(new Date(file.lastModified()).toLocaleString()); //최종 저장된 시간 아는 메소드
				
				//file.delete(); //파일삭제 (복구불가)

			} else { // 파일이 아닌 경우(폴더)
				System.out.println("*****" + fileName + "폴더의 정보 LIST ******");
				String fname[] = file.list(); // 파일을 배열형식으로 받아온다 .
				for(String name : fname) {
					System.out.println(name);
				}
			}
		} else {
			System.out.println(fileName + "은 없으니 생성하겠습니다.");
			file.createNewFile(); //파일 생성
			//file.mkdir();// 폴더 생성
		}

	}

	public static void main(String[] args) throws Exception {
		new FileExam();
	}

}
