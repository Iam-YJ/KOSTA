package view;

import gui.GUIMainView;

public class FailView {
	
	/**
	 * ���ܰ� �߻������� ���ܸ޼��� ���
	 */
	public static void errorMessage(String message){
		GUIMainView.appendConsoleField(message);
	}
	
}
