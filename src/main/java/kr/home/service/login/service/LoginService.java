package kr.home.service.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.home.service.user.repository.UserReposiry;
import kr.home.service.user.vo.UserVO;

@Service
public class LoginService {
	
	@Autowired
	UserReposiry userReposiry;
	public UserVO selectUser(String email, String password) {
		
		UserVO userVO = userReposiry.findByEmailAndPassword(email, password);
		
		return userVO;
	}
}
