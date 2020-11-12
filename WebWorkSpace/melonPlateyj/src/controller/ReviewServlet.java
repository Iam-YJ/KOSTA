package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.Reply;
import model.service.ReplyService;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/review")
public class ReviewServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   ReplyService service = new ReplyService();

   /**
    * @see HttpServlet#HttpServlet()
    */
   public ReviewServlet() {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void service(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");

      try {
         System.out.println("ReviewServlet 식당별리뷰검색");
         String resNo = request.getParameter("res_no");
         System.out.println("resNo: " + resNo);
         List<Reply> list = service.selectReplyByResNo(Integer.parseInt(resNo));
         System.out.println("list:" + list);
         // request.setAttribute("list", list);
         // request.setAttribute("count", list.size());

         JSONArray json = JSONArray.fromObject(list);
         System.out.println("json: " + json);
         PrintWriter out = response.getWriter();
         out.println(json);
      } catch (Exception e) {
         e.printStackTrace();

      }

   }
}