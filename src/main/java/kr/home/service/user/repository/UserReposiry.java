package kr.home.service.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.home.service.user.vo.UserVO;

@Repository
public interface UserReposiry extends JpaRepository<UserVO, Long>{

	public UserVO findByEmail(String email);	
}
