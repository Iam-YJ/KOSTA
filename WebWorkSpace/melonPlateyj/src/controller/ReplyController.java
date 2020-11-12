package controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.Melon;
import model.dto.Reply;
import model.service.MelonService;
import model.service.ReplyService;
import net.sf.json.JSONArray;

public class ReplyController implements Controller {
   
   ReplyService service = new ReplyService();

   @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
      // TODO Auto-generated method stub
      return null;
   }
   
   /**
    * 리뷰 전체 검색 - 식당
    */
   public void selectReplyByResNo(HttpServletRequest request, HttpServletResponse response) throws Exception {
      response.setContentType("text/html;charset=UTF-8");
      System.out.println("replyController 식당별리뷰검색");
      String resNo = request.getParameter("res_no"); 
      System.out.println("resNo: " + resNo);
      List<Reply> list= service.selectReplyByResNo(Integer.parseInt(resNo));
      System.out.println("list:" + list);
      //request.setAttribute("list", list);
      //request.setAttribute("count", list.size());
      
      JSONArray json = JSONArray.fromObject(list);
      System.out.println("json: " + json);
      PrintWriter out = response.getWriter();
      out.println(list);
      
   }
   
   /**
    * 리뷰 전체 검색 - 마이페이지
    */
   public ModelAndView selectReplyByUserNo(HttpServletRequest request, HttpServletResponse response) throws Exception {
      System.out.println("리뷰전체검색");
      String userNo = request.getParameter("user_no"); 
      System.out.println("userNo: " + userNo);
      
      List<Reply> list= service.selectReplyByUserNo(Integer.parseInt(userNo));
      request.setAttribute("list", list);
      request.setAttribute("count", list.size());
      
      System.out.println("list: " + list);
      
      return new ModelAndView("html/user_page/reviews.jsp", false);
   }
   
   /**
    * 리뷰 수정
    */
   public ModelAndView updateReply(HttpServletRequest request, HttpServletResponse response)throws Exception {
      System.out.println("updateReply() 메소드");
      String resNo = request.getParameter("resNo"); 
      String userNo = request.getParameter("userNo"); 
      String repGrade = request.getParameter("repGrade"); 
      //String repPhoto = request.getParameter("repPhoto");
      String repContent = request.getParameter("repContent");
      System.out.println("resNo: " + resNo);
      System.out.println("userNo: " + userNo);
      System.out.println("repGrade: " + repGrade);
      System.out.println("repContent: " + repContent);
      
      Reply reply = new Reply(Integer.parseInt(resNo), Integer.parseInt(userNo), Integer.parseInt(repGrade), null, repContent);
      
      service.updateReply(reply);
      
      return new ModelAndView("dispatcher?key=reply&methodName=selectReplyByUserNo&user_no="+Integer.parseInt(userNo), true);
   }
   
   /**
    * 리뷰 삭제
    */
   public ModelAndView deleteReply(HttpServletRequest request, HttpServletResponse response)throws Exception {
      
      String resNo = request.getParameter("res_no"); 
      String userNo = request.getParameter("user_no"); 
      System.out.println("resNo: " + resNo);
      System.out.println("userNo: " + userNo);
      
      service.deleteReply(Integer.parseInt(resNo), Integer.parseInt(userNo));
      
      return new ModelAndView("dispatcher?key=reply&methodName=selectReplyByUserNo&user_no="+Integer.parseInt(userNo), true);
   }
   
   /**
    * 리뷰 등록
    */
   public ModelAndView insertReply(HttpServletRequest request, HttpServletResponse response)throws Exception {
      System.out.println("replyController insert");
      String resNo = request.getParameter("res_no"); 
      String userNo = request.getParameter("user_no"); 
      String repGrade = request.getParameter("food_quality"); 
      //String repPhoto = request.getParameter("review_photo");
      String repContent = request.getParameter("review_content");
      
      
      System.out.println("resNo: " + resNo);
      System.out.println("userNo: " + userNo);
      System.out.println("repGrade: " + repGrade);
      //System.out.println("repPhoto: " + repPhoto);
      System.out.println("repContent: " + repContent);
      
      Reply reply = new Reply(Integer.parseInt(resNo), Integer.parseInt(userNo), Integer.parseInt(repGrade), null, repContent);
      System.out.println("reply: " + reply);
      service.insertReply(reply);
      
      return new ModelAndView("dispatcher?key=melon&methodName=selectDetailRes&resNo="+resNo,true);
   }
   
   /**
    * 리뷰 공감수 증가 
    */
   public ModelAndView incrementLike(HttpServletRequest request, HttpServletResponse response)throws Exception {
      System.out.println("공감수 증가");
      String reviewNo = request.getParameter("review_no");
            
      service.incrementLike(Integer.parseInt(reviewNo));
      return new ModelAndView("html/detail-restaurant.jsp", true);
   }
   
   /**
    * 식당번호, 유저번호에 해당하는 리뷰 가져오기 
    */
   public ModelAndView selectReplyByResNoAndUserNo(HttpServletRequest request, HttpServletResponse response)throws Exception {
      System.out.println("selectReplyByResNoAndUserNo() 메소드");
      String resNo = request.getParameter("res_no");
      String userNo = request.getParameter("user_no");
      System.out.println("resNo: " + resNo + ", " + "userNo: " + userNo);
      
      Reply reply = service.selectReplyByResNoAndUserNo(Integer.parseInt(resNo), Integer.parseInt(userNo));
      request.setAttribute("reply", reply);
      System.out.println("reply: " + reply);
      
      return new ModelAndView("html/update-review.jsp", false);
   }
   
}