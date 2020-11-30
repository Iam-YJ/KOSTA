package kosta.mvc.controller;

import org.springframework.stereotype.Controller;import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathVariableController {
	
	@RequestMapping(value= "/{type}/{id}.do")
	//depth 2�ܰ�� ������ �ֵ��� �� ���´� 
	public String aa(@PathVariable String type,@PathVariable String id) { //type=�� & id=��
		//@PathVariable�� ������ path�� �ֵ��� ������ ���Ŵ�
		// 					������ parameter�� ���Ŵ�
		System.out.println("/{type}/{id}.do �� ��û�Ǿ����ϴ�");
		System.out.println("type = "+type+", id = "+id);
			
		return "result";
	}
	
	@RequestMapping(value="/{user}") //	<url-pattern>/blog/*</url-pattern> �̶�� web.xml���� �����߱� ������ * �Ʒ��� ������ �ȴ�
	public String bb(@PathVariable String user) {
		System.out.println("blog/* ��û�Ǿ����ϴ�");
		System.out.println("user = "+user);
		return "result";
	}
	
	@RequestMapping(value="/{kind}/{name}/{no}")
	public String cc(@PathVariable String kind, @PathVariable String name, @PathVariable String no) {
		System.out.println("kind = "+kind+", name = "+name+", no = "+no);
		return "result";
		
		
		//�� <a href="user/borad/bbs/3">��û4</a> ���� ������ ���� ���� 
		// user ������ ������ �ϴ� ���� �������� �ʾұ� ����
	}
	
	@RequestMapping("/{url}.do")
	public void aaa() {
		//�̰��� ��������ν� ���ϴ� �������� �̵��� �� �ְ� �Ѵ�
		//url �ּҰ� �ٲ� �װ��� �� ������������ �� �� �ְ� �Ѵ�
		//���÷� http://localhost:8000/controller/user.do �� ��û�ϸ� =>  [/WEB-INF/views/user.jsp] �� �������Ѵ�
		System.out.println("!11");
	}

}
