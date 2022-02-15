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
		// 1. ���޹��� Authentication �ȿ��� id�� �����´�
		String userId = authentication.getName();
		
		// 2. id�� �ش��ϴ� ȸ�� ���� �˻�
		Member member = memberDAO.selectMemberById(userId);
		if(member==null) throw new UsernameNotFoundException(userId+"�� ��ġ���� �ʽ��ϴ�"); 
		//UsernameNotFoundException �� AuthenticationException�� extends �Ѵ� 
		
		// 3. �˻��� ȸ�������� ����� ���޹޴� Authentication �ȿ� �ִ� ��� ��
		String pass = authentication.getCredentials().toString();
		if(!passwordEncoder.matches(pass, member.getPassword() )) {
			//ù��° �μ��� ��, �ι�° �μ��� ��ȣȭ �� �� 	
			throw new UsernameNotFoundException("��й�ȣ �����Դϴ�");	
		}
		
		// 4. ��ΰ� ��ġ�ϸ� ȸ���� ���� ������ �˻��Ѵ� 
		List<Authority> list = authoritiesDAO.selectAuthorityByUserName(userId);
		
		if(list == null || list.size() == 0) {
			throw new UsernameNotFoundException("������������ ���� �߻��Ͽ� ���� ����");
		}
		
		// 5. Authentication�� ����Ŭ���� UserNamePasswordAuthenticationToken ��ü�� ���� �����Ѵ� 
		List<SimpleGrantedAuthority> authList = new ArrayList<SimpleGrantedAuthority>();
		
		for(Authority au : list) {
			authList.add(new SimpleGrantedAuthority(au.getRole()));
		}
		
		
		return new UsernamePasswordAuthenticationToken(member, null,authList );
		// UsernamePasswordAuthenticationToken(principal, password, authority)
	}

	
	/**
	 * �μ��� ���޵� authentication ���� �� �� �ִ� ��ȿ�� ��ü���� �Ǵ����ִ� �޼ҵ�
	 * 	: ���ϰ��� true�� authentication ȣ���
	 */
	@Override
	public boolean supports(Class<?> authentication) {
		
		
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication); 
		//�̰��� return�� true���߸� authenticate()�� ȣ��ȴ�. <- ������ ���� ��ü���� �ƴ��� ���� �ʿ�
		//�����ؼ� ���ܰ� ������ true, ���ܰ� ������ false
	}

}
