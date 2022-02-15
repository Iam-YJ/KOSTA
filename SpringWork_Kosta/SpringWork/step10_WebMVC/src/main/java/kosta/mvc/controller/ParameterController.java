package kosta.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kosta.mvc.model.dto.Member;

@Controller
@RequestMapping("/param")
public class ParameterController {
	
	//���� �Ѿ���� ���� getParameter�� �޾Ƶ� �ǰ� �Լ��� �޾Ƶ� �ȴ�
	//���� ������ �ѹ��� �Ѿ���� ���� .. 

	/*
	 * @RequestMapping("/a.do") public ModelAndView aa(HttpServletRequest request) {
	 * 
	 * String name = request.getParameter("name"); int age =
	 * Integer.parseInt(request.getParameter("age"));
	 * 
	 * System.out.println("name = "+name+" age = "+age);
	 * 
	 * return new ModelAndView("result", "message", "parameterController �Դϴ� "); }
	 */

	
	/**
	 * �Ű������� ���޹��� Model ��ü�� �������� ���޵� ��ü�̴�
	 * �Ű����� Model�� ������ �����ϸ� �信�� ����� �� �ִ�
	 */
	@RequestMapping("/a.do")
	public String aa(String name, Integer age, Model model) {
		//���⼭�� model�� view ������ ������ �� �ʿ��� model �̴�. -> springFramWork�� �˾Ƽ� ������ model and view�� ��������
		System.out.println(name + ", " + age);
		//null�̶�� ���� int�� ���� �� ����  => Integer
		
		model.addAttribute("message","�Ű����� model");

		
		return "result"; // WEB-INF/views/result.jsp
	}
	
	/**
	 * void�� ���� ������ param/c.jsp�� �̵��Ѵ�
	 * 
	 * parameter�� ���޵Ǵ� name�� ������ �Ӽ����� ������ �ִ� ��ü�� �μ��� �����ϸ�
	 * �� ��ü�� �����ؼ� setXxx() ���� �����ͷ� �������ش� 
	 * 
	 * parameter�� ���޵� ������ ��ü�� ���ε��ϸ� �� ��ü�� 
	 * view�� ���� �״�� ����� �� �ִ�. - Model ������ ������ �ȴ�
	 * => ������� �信�� ����� �� ��ü�̸��� ù���ڸ� �ҹ��ڷ� �����ؼ� 
	 *  ��, Member�̸� member�� ����Ѵ� ${member.id}
	 *  
	 *  
	 *  
	 *  @ModelAttribute�� �Ű������� �����ϸ�
	 *  ��ü�� ��Ī�� ���� ����� �� �ִ�.
	 *  �̷��� �ϸ� �� �������� ���� ��Ī���� �����ϰ� ���� �� �� �ִ�.
	 *  
	 */
	@PostMapping("/c.do")
	public void c(@ModelAttribute("m") Member member) {
		System.out.println(member.getAddr());
		System.out.println(member.getAge());
		System.out.println(member.getId());
		System.out.println(member.getName());
	}
	
	
	@ModelAttribute("hobbys") //�信�� ${hobbys} ���
	//���� ����ϴ� ��Ʈ�ѷ��� ��ȴ� ���� �ֵ鸸 ��� ���� 
	//model �̶�� ������ hobbys��� �̸����� �����ϰ� �ȴ� 
	public List<String> hobby(){
		List<String> list = new ArrayList<String>();
		list.add("���");
		list.add("����");
		list.add("����");
		list.add("����");
		
		return list;
		
	}
	
	@ModelAttribute("addr") //${addr}
	public String addr() {
		return "��⵵ ������";
	}
	
	/*
	 * parameter�� �Ѿ���� name�� �Ű������� �̸��� �ٸ� ��
	 * @RequestParam�� ����ؼ� �������� �� �ִ�
	 *  : @RequestParam�� �����ϸ� required = "true" �̴�.
	 *    ��, ���� �ݵ�� ���;� �Ѵ� 
	 *     => required = false�� �ٲٸ� ���� �� ������ �ʾƵ� �ȴ� 
	 *     
	 *  : defaultValue ="" �� ���ؼ� ������ �ʾ��� ���� ���� �����ش�
	 *    int�� ��쿡 ���� ������ null�ε� �� �� defaultValue�� ����ϸ� null�� ���� �߻��ϴ� ���� ���� �����ϴ�. 
	 */
	@RequestMapping("/d.do")
	public String dd(@RequestParam(value="id", defaultValue="Guest") String userId, @RequestParam(value="name", required=false) String userName,@RequestParam(defaultValue = "0") int age) {
		System.out.println("userId : "+userId);
		System.out.println("userName : "+userName);
		System.out.println("userAge : "+age);
		
		return "result";  //WEB-INF/viwes/result.jsp
	}

}