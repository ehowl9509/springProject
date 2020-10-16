package kr.home.service.join.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.home.service.email.handle.EmailSendHandle;
import kr.home.service.join.service.JoinService;

@Controller
public class JoinContoroller {
	
	@Autowired
	JoinService joinService;
	
	@Autowired
	EmailSendHandle emailSendHandle;
	
    @RequestMapping("/join/View")
    public String main() throws Exception{
        return "join/join";
    }
    
    @RequestMapping("/join/emailSend")
    public void mailSend(HttpServletRequest request, ModelMap model) throws Exception {
    	
    	String email = request.getParameter("email");
    	
    	String password = request.getParameter("password");
    	
    	String phoneNum = request.getParameter("phoneNum");
    	
    	String url = request.getRequestURL().toString();
    	
    	emailSendHandle.emailSend(email, password, phoneNum, url);
    	    
    }
    
    @RequestMapping("/join/emailSend/auth")
    public String mailAuth(HttpServletRequest request, ModelMap model) throws Exception {
    	
    	String email = request.getParameter("email")==null?null : request.getParameter("email");
    	
    	String password = request.getParameter("password")==null?null : request.getParameter("password");
    	
    	String phoneNum = request.getParameter("phoneNum")==null?null : request.getParameter("phoneNum");
    	
    	model.addAttribute("email", email);

    	String result = joinService.userSave(email, password, phoneNum);
    	
    	return "login/login";
    }
}
