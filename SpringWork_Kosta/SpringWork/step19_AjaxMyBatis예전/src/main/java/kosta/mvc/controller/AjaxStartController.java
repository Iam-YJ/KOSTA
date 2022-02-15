package kosta.mvc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosta.mvc.model.dto.MemberDTO;

@RestController // 이것은 @Controller + @ResponseBody 이다
public class AjaxStartController {

	@RequestMapping(value = "/load", produces = "text/html; charset=UTF-8")
	public String load() {
		return "spring과 Ajax의 만남";
	}
	
	@RequestMapping(value = "/ajax", produces = "text/html; charset=UTF-8")
	public String ajax(String name) {
		return name + "님 반가워용";
	}
	
	
	/**
	 * 응답 객체를 json 형태로 변환해서 뷰쪽으로 전달해주는 
	 * jackson LIB를 사용한다 
	 */
	@RequestMapping(value="/jsonArr")
	public List<String> jsonArr(){ 
		List<String> list = Arrays.asList(new String[] {"사과","수박","곶감","참외"});
		//jacson을 사용하면 알아서 됨
		return list;
	}
	
	@RequestMapping("jsonList")
	public List<MemberDTO> jsonList(){
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		list.add(new MemberDTO("kim","김정은",11,"북한대장"));
		list.add(new MemberDTO("lee","바이든",12,"미국대장"));
		list.add(new MemberDTO("ching","징기스칸",13,"몽골대장"));
		list.add(new MemberDTO("bo","보라돌이",14,"텔레토비대장"));
		list.add(new MemberDTO("bbung","뿡뿡이",15,"방구대장"));
		
		return list;
		
	}
	
	
	@RequestMapping("/jsonDto")
	public MemberDTO jsonDto() {
		
		return new MemberDTO("jang","장희정",20,"판교오");
	}
	
	@RequestMapping("/jsonMap")
	public Map<String, Object> jsonMap(){
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Spring Ajax 재밌땅");
		map.put("pageNumber", 10);
		map.put("dto", new MemberDTO("bbung","뿡뿡이",15,"방구대장"));
		
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		list.add(new MemberDTO("ching","징기스칸",13,"몽골대장"));
		list.add(new MemberDTO("bo","보라돌이",14,"텔레토비대장"));
		list.add(new MemberDTO("bbung","뿡뿡이",15,"방구대장"));
		map.put("list", list);
		
		
		return map;
	}
}
