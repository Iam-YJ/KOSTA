package kosta.mvc.web.dto;

public class TransferDTO {
   private String output; //��ݰ��¹�ȣ
   private String input;//�Աݰ��¹�ȣ
   private int transferAmount;// ������ü �� �ݾ�
   
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
