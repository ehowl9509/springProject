package kr.home.service.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeContoroller {
	
    @RequestMapping("/home/main")
    public String main() throws Exception{
        return "home/mainHome";
    }
    
}
