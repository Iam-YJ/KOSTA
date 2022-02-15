package kosta.mvc.controller;

public class ModelAndView {

	private String viewName;
	private boolean isRedirect; // false이면 forward, true이면 redirect 이동

	public ModelAndView() {

	}

	public ModelAndView(String viewName, boolean isRedirect) {
		this.viewName = viewName;
		this.isRedirect = isRedirect;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

}
