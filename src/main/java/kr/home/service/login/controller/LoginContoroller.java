package kr.home.service.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginContoroller {
	
    @RequestMapping("/login")
    public String main(HttpServletRequest request) throws Exception{
    	
        return "login/login";
    }
}
