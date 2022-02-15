package ex0818;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputExam {
    public FileInputOutputExam() {
    	FileInputStream fis=null;
    	FileOutputStream fos = null;
    	try {
    	  //byte������ ���� �б�
    	   fis = new FileInputStream("src/ex0818/read.txt");
//    	   while(true) {
//    	     int i = fis.read(); //1byte�б�
//    	     if(i==-1)break;
//    	     System.out.println(i +" = " + (char)i);
//    	   }
    	   
    	   
    	   
//    	   int i = 0;
//    	   while((i=fis.read()) != -1) {
//    		   System.out.println(i + " = " + (char)i);
//    	   }
    	   ///////////////////////////////////////////////////
    	   
    	   
    	   int len = fis.available();
    	   byte [] b = new byte [len]; //fis.available()�� ���� �� �ִ� byte ���� ��ȯ���ش� 
    	   fis.read(b);
    	   
    	   for(byte i : b) {
				System.out.println(b);
			}
    	   
    	   
    	   //byte �迭�� -> String���� ��ȯ 
    	   String str = new String(b);
    	   System.out.println(str);
    	   
    	   
    	   //���� ����(����)
    	   //fos = new FileOutputStream("src/ex0818/write.txt"); //����� 
    	   fos = new FileOutputStream("src/ex0818/write.txt", true); //�����Ϸ��� ������ �־���Ѵ�. ���ϸ�! ������ش� //�̾��
    	   fos.write(97);
    	   fos.write(100);
    	   fos.write(32); //����
    	   
    	   fos.write(13); //����
    	   fos.write(10); //����
    	  
    	  fos.write(100);
    	   //String --> byte �迭�� ��ȯ.
    	   String message = "�������ô�";
    	   fos.write(message.getBytes()); //message(String) -> byte [] -> write�� �ֱ� 
    	   
    	   
    	   System.out.println("***��****");
    	  
    	}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
		}finally {
			try {
			  if(fis!=null)fis.close();
			  if(fos!=null)fos.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
    }//�����ڳ�
	public static void main(String[] args) {
		new FileInputOutputExam();

	}

}
