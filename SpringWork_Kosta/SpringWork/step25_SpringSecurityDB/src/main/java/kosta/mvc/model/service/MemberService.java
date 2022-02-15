package kosta.mvc.model.service;

import org.springframework.stereotype.Service;

import kosta.mvc.model.vo.Member;

public interface MemberService {

	/**
	 * 회원가입
	 * */
	int joinMember(Member member);
	
	
}
