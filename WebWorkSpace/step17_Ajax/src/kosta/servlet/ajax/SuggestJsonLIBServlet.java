package kosta.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class SuggestServlet
 */
@WebServlet("/suggestJsonLIB")
public class SuggestJsonLIBServlet extends HttpServlet {
	private String [] words = {
			"�ڹ�","�ڹ��ڹ�","�ڹ�Ĩ������ġ��","����","ȣ�θ���","ȣȣ","���","Ajax","ajax","AAAA","aaa",
			"����","����","�������Ͱ���","�� ������"
	};
	
	
	/*
	 * �μ��� ���޵� �ܾ�� �����ϴ� �ܾ���� ��Ƽ� �������ش�
	 */
	public List<String> search(String keyWord) {
		
		List<String> list = new ArrayList<String>();
		
		for(String word : words) {
			if(word.toUpperCase().startsWith(keyWord.toUpperCase())) {
				list.add(word);
			}
		}
		return list;
		
	}
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String keyWord = request.getParameter("keyWord");
		//System.out.println(keyWord);
		List<String> list =  this.search(keyWord);
		
		//list�� json���� ��ȯ�Ѵ� 
		JSONArray arr = JSONArray.fromObject(list);
		
		PrintWriter out = response.getWriter();
		out.print(arr);
	}

}
