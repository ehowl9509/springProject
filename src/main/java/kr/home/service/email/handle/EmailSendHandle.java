package kr.home.service.email.handle;

import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Component
public class EmailSendHandle {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public String emailSend(String email, String password, String phoneNum, String url) {
		
   	
   	MimeMessage messagesend = javaMailSender.createMimeMessage();
   	
   	try {
   		
   		messagesend.setFrom("SpringWEB-IngyuAhn");
    	
   		messagesend.addRecipient(RecipientType.TO, new InternetAddress(email));
        
   		messagesend.setSubject("안녕하세요 인증메일이 도착하였습니다.");
        
   		messagesend.setText("<a href="+ url +"/auth?email="+ email +"&password="+ password +"&phoneNum="+ phoneNum +">인증하기</a>", "UTF-8", "html");
        
        javaMailSender.send(messagesend);
        
        return "1";
        
   	}catch(Exception e) {
   		e.printStackTrace();
   	}
   	
   	return "1";
	}
}
