package kosta.mvc.model.dto;

public class Reply {
	private int replyNo;
	private String content;
	private int boardNo;
	private String regDate;

	public Reply() {
	}

	public Reply(int replyNo, String content, int boardNo, String regDate) {
		this.replyNo = replyNo;
		this.content = content;
		this.boardNo = boardNo;
		this.regDate = regDate;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reply [replyNo=");
		builder.append(replyNo);
		builder.append(", content=");
		builder.append(content);
		builder.append(", boardNo=");
		builder.append(boardNo);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append("]");
		return builder.toString();
	}
	
	

}
