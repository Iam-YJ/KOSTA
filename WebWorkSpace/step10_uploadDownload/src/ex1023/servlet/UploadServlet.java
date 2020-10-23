package ex1023.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UpLoad")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 전송된 데이터 받기
		/*
		 * String name = request.getParameter("name"); String subject =
		 * request.getParameter("subject"); String file = request.getParameter("file");
		 * 
		 * - 폼에서 enctype="multipart/form-data" 설정되면 request로 데이터를 받을 수 없다 cos.jar에서 제공되는
		 * 클래스를 이용한다
		 */

		String saveDir = request.getServletContext().getRealPath("/save");
		int maxSize = 1024 * 1024 * 100; // 100M
		String encoding = "UTF-8";

		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());

		String name = m.getParameter("name");
		String subject = m.getParameter("subject");
		String file = m.getParameter("file");

		String systemFileName = m.getFilesystemName("file");
		String originalFileName = m.getOriginalFileName("file");

		// 파일의 정보
		File f = m.getFile("file");
		long fileSize = f.length();

		System.out.println("name = " + name);
		System.out.println("subject = " + subject);
		System.out.println("file = " + file);
		System.out.println("systemfileName " + systemFileName);
		System.out.println("originalfileName " + originalFileName);
		System.out.println("fileSize " + fileSize);

		// 뷰로 이동하기 전에 뷰쪽으로 전달될 정보를 저장
		request.setAttribute("name", name);//jsp에서 ${requestScope.name} -> ${name}
		request.setAttribute("subject", subject);
		request.setAttribute("systemfileName", systemFileName);
		request.setAttribute("originalfileName", originalFileName);
		request.setAttribute("fileSize", fileSize);
		request.setAttribute("saveDir", saveDir);

		// forward 방식으로 이동
		request.getRequestDispatcher("uploadResult.jsp").forward(request, response);
		
	}

}
