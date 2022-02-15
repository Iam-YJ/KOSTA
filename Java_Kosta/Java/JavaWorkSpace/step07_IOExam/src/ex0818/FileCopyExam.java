package ex0818;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

public class FileCopyExam {

	public FileCopyExam(String readFile, String writeFile) {
		FileInputStream bis = null; // buffer�� �̿��� byte ���� �б�
		FileOutputStream bos = null; // buffer�� �̿��� byte ���� ����

		try {
			bis = new FileInputStream(readFile);
			bos = new FileOutputStream(writeFile);
			
			int i = 0;
			while((i=bis.read())!= -1) {
				bos.write(i);
			}
			System.out.println("���� ���� �Ϸ�!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis != null)
					bis.close();
				if (bos != null)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
					bos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		String readFile = JOptionPane.showInputDialog("������ ���ϸ��� ? ");
		String writeFile = JOptionPane.showInputDialog("������ ���ϸ��� ? ");
		
		long start = System.nanoTime();
		new FileCopyExam(readFile, writeFile);
		long end = System.nanoTime();
		System.out.println(" �� �ɸ� �ð� : "+(end-start)+ " ns");

	}

}
