package kosta.mvc.model.service;

import org.springframework.stereotype.Service;

import kosta.mvc.model.vo.Member;

public interface MemberService {

	/**
	 * ȸ������
	 * */
	int joinMember(Member member);
	
	
}
