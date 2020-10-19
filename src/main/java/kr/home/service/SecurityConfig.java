package kr.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity // 1
@Configuration 
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	

	@Autowired
	AuthProvider authProvider;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/resources/**", "/css/**", "/js/**", "/img/**").permitAll()
                .antMatchers("/join/**/**", "/home/**/**").permitAll()
                .antMatchers("/**/**/**").hasRole("USER")
                .anyRequest().authenticated();
        http.formLogin()
                .loginPage("/login") // default
                .loginProcessingUrl("/authenticate")
                .failureUrl("/login?error") // default
                .defaultSuccessUrl("/home/main")
                .usernameParameter("email")
                .passwordParameter("password")
                .permitAll();
        http.logout()
                .logoutUrl("/logout") // default
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
                .permitAll();
        http.authenticationProvider(authProvider);
        http.csrf()
        	.csrfTokenRepository(new CookieCsrfTokenRepository());
        
        
    }
    
    
}
