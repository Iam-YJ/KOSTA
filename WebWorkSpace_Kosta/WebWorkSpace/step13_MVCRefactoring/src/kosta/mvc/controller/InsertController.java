package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("insertController �Դϴ�");

		// ���� ȣ�� - dao ȣ��
		request.setAttribute("message", "���� ��� �����߾��");

		// ����� ���������� Redirect ������� select ��û �Ѵ�
		ModelAndView mv = new ModelAndView("front?key=select", true);

		return mv;
	}

}
