package kosta.mvc.security.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kosta.mvc.model.dao.AuthoritiesDAO;
import kosta.mvc.model.dao.MemberDAO;
import kosta.mvc.model.vo.Authority;
import kosta.mvc.model.vo.Member;
import lombok.RequiredArgsConstructor;

@Service //id="memberAuthenticationProvider"
@RequiredArgsConstructor
public class MemberAuthenticationProvider implements AuthenticationProvider {

	private final MemberDAO memberDAO;
	private final AuthoritiesDAO authoritiesDAO;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// 1. 전달받은 Authentication 안에서 id를 가져온다
		String userId = authentication.getName();
		
		// 2. id에 해당하는 회원 정보 검색
		Member member = memberDAO.selectMemberById(userId);
		if(member==null) throw new UsernameNotFoundException(userId+"는 일치하지 않습니다"); 
		//UsernameNotFoundException 은 AuthenticationException을 extends 한다 
		
		// 3. 검색된 회원정보의 비번과 전달받는 Authentication 안에 있는 비번 비교
		String pass = authentication.getCredentials().toString();
		if(!passwordEncoder.matches(pass, member.getPassword() )) {
			//첫번째 인수가 평문, 두번째 인수가 암호화 된 것 	
			throw new UsernameNotFoundException("비밀번호 오류입니당");	
		}
		
		// 4. 모두가 일치하면 회원의 권한 정보를 검색한다 
		List<Authority> list = authoritiesDAO.selectAuthorityByUserName(userId);
		
		if(list == null || list.size() == 0) {
			throw new UsernameNotFoundException("권한정보에서 오류 발생하여 인증 실패");
		}
		
		// 5. Authentication의 구현클래스 UserNamePasswordAuthenticationToken 객체를 만들어서 리턴한다 
		List<SimpleGrantedAuthority> authList = new ArrayList<SimpleGrantedAuthority>();
		
		for(Authority au : list) {
			authList.add(new SimpleGrantedAuthority(au.getRole()));
		}
		
		
		return new UsernamePasswordAuthenticationToken(member, null,authList );
		// UsernamePasswordAuthenticationToken(principal, password, authority)
	}

	
	/**
	 * 인수로 전달된 authentication 인증 할 수 있는 유효한 객체인지 판단해주는 메소드
	 * 	: 리턴값이 true인 authentication 호출됨
	 */
	@Override
	public boolean supports(Class<?> authentication) {
		
		
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication); 
		//이것의 return이 true여야만 authenticate()가 호출된다. <- 문제가 없는 객체인지 아닌지 검증 필요
		//검증해서 예외가 없으면 true, 예외가 있으면 false
	}

}
