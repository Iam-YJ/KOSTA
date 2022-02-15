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
    	  //byte단위로 파일 읽기
    	   fis = new FileInputStream("src/ex0818/read.txt");
//    	   while(true) {
//    	     int i = fis.read(); //1byte읽기
//    	     if(i==-1)break;
//    	     System.out.println(i +" = " + (char)i);
//    	   }
    	   
    	   
    	   
//    	   int i = 0;
//    	   while((i=fis.read()) != -1) {
//    		   System.out.println(i + " = " + (char)i);
//    	   }
    	   ///////////////////////////////////////////////////
    	   
    	   
    	   int len = fis.available();
    	   byte [] b = new byte [len]; //fis.available()는 읽을 수 있는 byte 수를 반환해준다 
    	   fis.read(b);
    	   
    	   for(byte i : b) {
				System.out.println(b);
			}
    	   
    	   
    	   //byte 배열을 -> String으로 변환 
    	   String str = new String(b);
    	   System.out.println(str);
    	   
    	   
    	   //파일 저장(쓰기)
    	   //fos = new FileOutputStream("src/ex0818/write.txt"); //덮어쓰기 
    	   fos = new FileOutputStream("src/ex0818/write.txt", true); //저장하려는 폴더는 있어야한다. 파일만! 만들어준다 //이어쓰기
    	   fos.write(97);
    	   fos.write(100);
    	   fos.write(32); //공백
    	   
    	   fos.write(13); //개행
    	   fos.write(10); //개행
    	  
    	  fos.write(100);
    	   //String --> byte 배열로 변환.
    	   String message = "졸지맙시다";
    	   fos.write(message.getBytes()); //message(String) -> byte [] -> write에 넣기 
    	   
    	   
    	   System.out.println("***끝****");
    	  
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
    }//생성자끝
	public static void main(String[] args) {
		new FileInputOutputExam();

	}

}
