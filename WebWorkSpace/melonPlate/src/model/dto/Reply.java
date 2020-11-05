package model.dto;

public class Reply {
   private int reviewNo; // 리뷰No
   private int resNo; // 식당No
   private int userNo; // 유저No
   private int repHits; // 리뷰 조회수
   private int repGrade; // 리뷰 평점
   private String repPhoto; // 리뷰 사진
   private String repContent; // 리뷰 내용
   private String repDate; // 리뷰 날짜
   private int repAgree; // 리뷰 공감수

   public Reply(int reviewNo, int resNo, int userNo, int repHits, int repGrade, String repPhoto, String repContent,
         String repDate, int repAgree) {
      this.reviewNo = reviewNo;
      this.resNo = resNo;
      this.userNo = userNo;
      this.repHits = repHits;
      this.repGrade = repGrade;
      this.repPhoto = repPhoto;
      this.repContent = repContent;
      this.repDate = repDate;
      this.repAgree = repAgree;
   }
   
   /**
    * 수정용 생성자
    */
   public Reply(int resNo, int userNo, int repGrade, String repPhoto, String repContent) {
	   this.resNo = resNo;
	   this.userNo = userNo;
	   this.repGrade = repGrade;
	   this.repPhoto = repPhoto;
	   this.repContent = repContent;
   }

   public int getReviewNo() {
      return reviewNo;
   }

   public void setReviewNo(int reviewNo) {
      this.reviewNo = reviewNo;
   }

   public int getResNo() {
      return resNo;
   }

   public void setResNo(int resNo) {
      this.resNo = resNo;
   }

   public int getUserNo() {
      return userNo;
   }

   public void setUserNo(int userNo) {
      this.userNo = userNo;
   }

   public int getRepHits() {
      return repHits;
   }

   public void setRepHits(int repHits) {
      this.repHits = repHits;
   }

   public int getRepGrade() {
      return repGrade;
   }

   public void setRepGrade(int repGrade) {
      this.repGrade = repGrade;
   }

   public String getRepPhoto() {
      return repPhoto;
   }

   public void setRepPhoto(String repPhoto) {
      this.repPhoto = repPhoto;
   }

   public String getRepContent() {
      return repContent;
   }

   public void setRepContent(String repContent) {
      this.repContent = repContent;
   }

   public String getRepDate() {
      return repDate;
   }

   public void setRepDate(String repDate) {
      this.repDate = repDate;
   }

   public int getRepAgree() {
      return repAgree;
   }

   public void setRepAgree(int repAgree) {
      this.repAgree = repAgree;
   }

}