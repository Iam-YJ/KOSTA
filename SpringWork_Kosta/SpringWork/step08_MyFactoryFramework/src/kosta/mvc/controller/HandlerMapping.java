package kosta.mvc.controller;

/**
 * 현재 요청이 어떤 컨트롤러를 실행해야하는지 찾아주는 역할
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
