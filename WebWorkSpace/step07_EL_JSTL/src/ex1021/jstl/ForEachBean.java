package ex1021.jstl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ex1021.dto.Member;

public class ForEachBean {

	private String name [] = {"수현","현빈","지현","량훈","유진"};
	private List<String> menus = Arrays.asList("짜장","짬뽕","탕수육","깐쇼새우","팔보채","꿔바로우");
	private List<Member> memberList = new ArrayList<>();
	private Map<String, String> map = new HashMap<>();
	
	public ForEachBean() {
		//memberList와 map을 초기화
		memberList.add(new Member("lee", "이경민", 30,"안양"));
		memberList.add(new Member("lee2", "이수현", 26,"동탄"));
		memberList.add(new Member("park", "박유진", 25,"모란"));
		memberList.add(new Member("choi", "최윤우", 29,"안암"));
		
		
		map.put("kr","대한민국");
		map.put("us","미국");
		map.put("fr","프랑스");
		map.put("jp","일본");
	}

	public String[] getName() {//jsp에서 표현언어 ${변수이름.names}
		return name;
	}

	public List<String> getMenus() {//${변수이름.menus}
		return menus;
	}

	public List<Member> getMemberList() {//${변수이름.memberList}
		return memberList;
	}

	public Map<String, String> getMap() {//${변수이름.map}
		return map;
	}
	
	
	
	
	
	
	
}
