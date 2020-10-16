package kr.home.service.join.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.home.service.user.repository.UserReposiry;
import kr.home.service.user.vo.UserVO;

@Service
public class JoinService {

	@Autowired
	UserReposiry userReposiry;
	
	public String userSave(String email, String password, String phoneNum) {
		
		UserVO userVO = UserVO.builder()
				.email(email)
				.password(password)
				.phonenum(phoneNum)
				.build();
		
		userReposiry.save(userVO);
		
		return "1";
	} 
	
}
