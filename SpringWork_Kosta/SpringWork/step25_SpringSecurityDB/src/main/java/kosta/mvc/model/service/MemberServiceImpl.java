package kosta.mvc.model.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kosta.mvc.model.dao.AuthoritiesDAO;
import kosta.mvc.model.dao.MemberDAO;
import kosta.mvc.model.vo.Authority;
import kosta.mvc.model.vo.Member;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

	private final MemberDAO memberDAO;

	private final AuthoritiesDAO authoritiesDAO;

	private final PasswordEncoder passwordEncoder; // 이것을 주입받는 이유는 BCRYPT를 어디선가 만들기 위해
	// security.xml에 Bcrypt 넣어놨다

	@Override
	public int joinMember(Member member) {

		// 전달된 비밀번호 평문을 암호화 한다 -> 이를 위해 passwordEncoder 필요
		// 평문 (member.getPassword())
		String pass = passwordEncoder.encode(member.getPassword());
		member.setPassword(pass);

		// member 테이블에 가입한다 - insert
		int result = memberDAO.insertMember(member);
		if(result == 0) throw new RuntimeException("가입되지 않았습니다");
		
		// 권한 테이블에 등록한다 
		if(member.getUserType() == null) {
			throw new RuntimeException("userType을 체크해주세요");
		}
		
		// usertype에 따라 권한 테이블에 insert한다 -> 이를 위해 authoritiesDAO 필요
		result = authoritiesDAO.insertAuthority(new Authority(member.getId(), RoleConstants.ROLE_MEMBER));
		
		if(result == 0) throw new RuntimeException("권한 설정에 오류 발생했습니다");
		
		if(member.getUserType().equals("1")) { // 1이면 관리자임 
			result = authoritiesDAO.insertAuthority(new Authority(member.getId(), RoleConstants.ROLE_ADMIN));
			
			if(result == 0) throw new RuntimeException("예외가 발생하여 권한 설정에 오류 발생했습니다");
		}

		return result;
	}

}
