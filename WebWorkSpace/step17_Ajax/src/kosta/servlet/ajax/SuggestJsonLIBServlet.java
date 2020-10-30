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
			"자바","자바자바","자바칩프라프치노","녹차","호두마루","호호","녹녹","Ajax","ajax","AAAA","aaa",
			"하잉","바잉","웹마스터과정","웹 개발자"
	};
	
	
	/*
	 * 인수로 전달된 단어로 시작하는 단어들을 모아서 리턴해준다
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
		
		//list를 json으로 변환한다 
		JSONArray arr = JSONArray.fromObject(list);
		
		PrintWriter out = response.getWriter();
		out.print(arr);
	}

}
