package kosta.mvc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosta.mvc.model.dto.MemberDTO;

@RestController // �̰��� @Controller + @ResponseBody �̴�
public class AjaxStartController {

	@RequestMapping(value = "/load", produces = "text/html; charset=UTF-8")
	public String load() {
		return "spring�� Ajax�� ����";
	}
	
	@RequestMapping(value = "/ajax", produces = "text/html; charset=UTF-8")
	public String ajax(String name) {
		return name + "�� �ݰ�����";
	}
	
	
	/**
	 * ���� ��ü�� json ���·� ��ȯ�ؼ� �������� �������ִ� 
	 * jackson LIB�� ����Ѵ� 
	 */
	@RequestMapping(value="/jsonArr")
	public List<String> jsonArr(){ 
		List<String> list = Arrays.asList(new String[] {"���","����","����","����"});
		//jacson�� ����ϸ� �˾Ƽ� ��
		return list;
	}
	
	@RequestMapping("jsonList")
	public List<MemberDTO> jsonList(){
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		list.add(new MemberDTO("kim","������",11,"���Ѵ���"));
		list.add(new MemberDTO("lee","���̵�",12,"�̱�����"));
		list.add(new MemberDTO("ching","¡�⽺ĭ",13,"�������"));
		list.add(new MemberDTO("bo","������",14,"�ڷ�������"));
		list.add(new MemberDTO("bbung","�׻���",15,"�汸����"));
		
		return list;
		
	}
	
	
	@RequestMapping("/jsonDto")
	public MemberDTO jsonDto() {
		
		return new MemberDTO("jang","������",20,"�Ǳ���");
	}
	
	@RequestMapping("/jsonMap")
	public Map<String, Object> jsonMap(){
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Spring Ajax ��ն�");
		map.put("pageNumber", 10);
		map.put("dto", new MemberDTO("bbung","�׻���",15,"�汸����"));
		
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		list.add(new MemberDTO("ching","¡�⽺ĭ",13,"�������"));
		list.add(new MemberDTO("bo","������",14,"�ڷ�������"));
		list.add(new MemberDTO("bbung","�׻���",15,"�汸����"));
		map.put("list", list);
		
		
		return map;
	}
}
