

import java.io.File;
import java.sql.Date;

import javax.swing.JOptionPane;

public class FileExam {

	public FileExam() throws Exception {
		String fileName = JOptionPane.showInputDialog("���� �̸���?");
//		System.out.println(fileName);
		File file = new File(fileName);
		if (file.exists()) {
			System.out.println(fileName + "�� �ֽ��ϴ�.");
			if (file.isFile()) {
				System.out.println("*****" + fileName + "�� ���� ******");
				System.out.println("�б��� : " + file.canRead());
				System.out.println("������ : " + file.canWrite());
				System.out.println("������ : " + file.getAbsolutePath());
				System.out.println("�����̸� : " + file.getName());
				System.out.println("���Ͽ뷮(byte) : " + file.length());
				System.out.println("������ ������  : " + file.lastModified());
				
				System.out.println(new Date(file.lastModified()).toLocaleString()); //���� ����� �ð� �ƴ� �޼ҵ�
				
				//file.delete(); //���ϻ��� (�����Ұ�)

			} else { // ������ �ƴ� ���(����)
				System.out.println("*****" + fileName + "������ ���� LIST ******");
				String fname[] = file.list(); // ������ �迭�������� �޾ƿ´� .
				for(String name : fname) {
					System.out.println(name);
				}
			}
		} else {
			System.out.println(fileName + "�� ������ �����ϰڽ��ϴ�.");
			file.createNewFile(); //���� ����
			//file.mkdir();// ���� ����
		}

	}

	public static void main(String[] args) throws Exception {
		new FileExam();
	}

}
