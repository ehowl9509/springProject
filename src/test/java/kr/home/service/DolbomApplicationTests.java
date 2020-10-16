package kr.home.service;
import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class DolbomApplicationTests {
	
	 private static final String DRIVER = "com.mysql.jdbc.Driver";
	 private static final String URL = "jdbc:mysql://127.0.0.1:3306/test1"; // jdbc:mysql://127.0.0.1:3306/여러분이 만드신 스키마이름
	 private static final String USER = "root"; //DB 사용자명
	 private static final String PW = "1234";   //DB 사용자 비밀번호

	@Test
	void contextLoads() {
		  
		  try(Connection con = DriverManager.getConnection(URL, USER, PW)){
		   Class.forName(DRIVER);
		   System.out.println("성공");
		   System.out.println(con);
		  }catch (Exception e) {
		   System.out.println("에러발생");
		   e.printStackTrace();

		  }
	}

}
