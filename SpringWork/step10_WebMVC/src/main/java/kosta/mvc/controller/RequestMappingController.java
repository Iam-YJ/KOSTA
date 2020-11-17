package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rem") // rem������ ������ ������ �޾Ƶ��̰� ��
public class RequestMappingController {

	/**
	 * ����Ÿ�� String : ���ϵǴ� ���ڿ��� ���� �̸��� �ȴ�
	 */
	@RequestMapping("/a.do") // rem ������ a.do��� ��û�� ������
	public String aa() {
		System.out.println("rem/a.do ��û�� �Ǿ����ϴ�");

		return "result"; // WEB-INF/views/result.jsp �̵�
	}

	/**
	 * b.do �Ǵ� c.do ��û�� �ϳ��� �޼ҵ� ����
	 * 
	 * ����Ÿ���� void�� ��� : ��û�� �ּҰ� view �̸��� �ȴ� 
	 * ex) rem/a.do�� ��û�Ǹ� ���� �̸��� rem/a => ���� �� ������ /WEB-INF/views/rem/a.jsp�� �ȴ�
	 * 
	 */
	@RequestMapping(value = { "/b.do", "c.do" }) // rem ������ a.do��� ��û�� ������
	public void bb() {
		System.out.println("rem/b.do �Ǵ� rem/c.do ��û ��û�� �Ǿ����ϴ�");
		// ���� [/WEB-INF/views/rem/b.jsp]��(��) ã�� �� �����ϴ�.
		// ���� [/WEB-INF/views/rem/c.jsp]��(��) ã�� �� �����ϴ�.

	}

	// @RequestMapping(value = "/test.do", method = RequestMethod.GET) // rem ������
	// a.do��� ��û�� ������
	@GetMapping("/test.do")
	public String test(HttpServletRequest request) {
		String name = request.getParameter("name");

		System.out.println("/test.do ��û�� �Ǿ����ϴ�.. GET ���");
		System.out.println("name = " + name);

		return "result"; // WEB-INF/views/result.jsp �� �̵�

	}

	// @RequestMapping(value = "/test.do", method = RequestMethod.POST) // rem ������
	// a.do��� ��û�� ������
	@PostMapping("/test.do")
	public String test2(String name) {
		System.out.println("/test.do ��û�� �Ǿ����ϴ� ... POST ���");
		System.out.println("name = " + name);

		return "result"; // WEB-INF/views/result.jsp �� �̵�

	}
	
	
	/**
	 * parameter ������ ���� ����Ǵ� �޼ҵ带 �ٸ���
	 * 
	 */
	//@RequestMapping(value = "/a.do" , params= {"id"})
	@RequestMapping(value = "/a.do" , params= {"id=jang"})
	//@RequestMapping(value = "/a.do" , params= {"id","age"})
	//@RequestMapping(value = "/a.do" , params= {"id != jang"})
	public ModelAndView aaa() {
		System.out.println("params�� ������ test ���Դϴ�");
		
		return new ModelAndView("result"); // WEB-INF/views/result.jsp �̵� 
	}
}
