package controller;
/**
 * 각각의 Controller의 구현체가 실행된 후에 
 * 이동해야할 뷰의 정보와 이동방식을 관리해 줄 객체
 */
public class ModelAndView {
	private String viewName;
	
	/**
	 * false이면 forward방식, true이면 redirect방식
	 */
	private boolean isRedirect;
	
	public ModelAndView() {}
	public ModelAndView(String viewName, boolean isRedirect) {
		this.viewName = viewName;
		this.isRedirect = isRedirect;
	}
	
	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName =viewName;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect){
		this.isRedirect = isRedirect;
	}
}


