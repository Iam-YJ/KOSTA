package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.service.ReplyService;

/**
 * Servlet implementation class ReviewLikeServlet
 */
@WebServlet("/like")
public class ReviewLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ReplyService service = new ReplyService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewLikeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("공감수 증가");
			String reviewNo = request.getParameter("review_no");
			System.out.println("reviewNo: " + reviewNo);
			int result = service.incrementLike(Integer.parseInt(reviewNo));
			System.out.println("result: " + result);
			
			int like = service.selectLikeByReviewNo(Integer.parseInt(reviewNo));
			
			PrintWriter out = response.getWriter();
			out.println(like);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
