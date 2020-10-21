package ex1021.jstl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ex1021.dto.Member;

public class ForEachBean {

	private String name [] = {"����","����","����","����","����"};
	private List<String> menus = Arrays.asList("¥��","«��","������","������","�Ⱥ�ä","��ٷο�");
	private List<Member> memberList = new ArrayList<>();
	private Map<String, String> map = new HashMap<>();
	
	public ForEachBean() {
		//memberList�� map�� �ʱ�ȭ
		memberList.add(new Member("lee", "�̰��", 30,"�Ⱦ�"));
		memberList.add(new Member("lee2", "�̼���", 26,"��ź"));
		memberList.add(new Member("park", "������", 25,"���"));
		memberList.add(new Member("choi", "������", 29,"�Ⱦ�"));
		
		
		map.put("kr","���ѹα�");
		map.put("us","�̱�");
		map.put("fr","������");
		map.put("jp","�Ϻ�");
	}

	public String[] getName() {//jsp���� ǥ����� ${�����̸�.names}
		return name;
	}

	public List<String> getMenus() {//${�����̸�.menus}
		return menus;
	}

	public List<Member> getMemberList() {//${�����̸�.memberList}
		return memberList;
	}

	public Map<String, String> getMap() {//${�����̸�.map}
		return map;
	}
	
	
	
	
	
	
	
}
