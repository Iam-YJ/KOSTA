package kosta.mvc.web.dto;

public class TransferDTO {
   private String output; //출금계좌번호
   private String input;//입금계좌번호
   private int transferAmount;// 계좌이체 할 금액
   
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public int getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(int transferAmount) {
		this.transferAmount = transferAmount;
	}
   
   
}
