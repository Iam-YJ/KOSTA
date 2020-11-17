package kosta.mvc.controller;

/**
 * ���� ��û�� � ��Ʈ�ѷ��� �����ؾ��ϴ��� ã���ִ� ����
 * 
 */
public class HandlerMapping {
	private static HandlerMapping factory = new HandlerMapping();

	private HandlerMapping() {

	}

	public static HandlerMapping getFactory() {
		return factory;
	}

	public Controller create(String command) {
		Controller controller = null;
		if (command.equals("insert")) {
			controller = new InsertController();
		} else if (command.equals("select")) {
			controller = new SelectController();
		} else if (command.equals("delete")) {
			controller = new DeleteController();
		}
		return controller;
	}
}
