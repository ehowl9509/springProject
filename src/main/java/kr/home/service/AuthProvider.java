package kr.home.service;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import kr.home.service.login.service.LoginService;
import kr.home.service.user.vo.UserVO;

@Component
public class AuthProvider implements AuthenticationProvider{
	
    @Autowired
    LoginService loginsevice;


	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserVO user = loginsevice.selectUser(email);
        
        // email에 맞는 user가 없거나 비밀번호가 맞지 않는 경우.
        if (null == user ) {
        	System.out.println("없음!");
            return null;
        }
        
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_USER"));

        // 로그인 성공시 로그인 사용자 정보 반환
        return new UsernamePasswordAuthenticationToken(user, null, grantedAuthorityList);

	}

	
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



}
