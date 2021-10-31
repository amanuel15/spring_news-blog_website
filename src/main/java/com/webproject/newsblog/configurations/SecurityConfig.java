package com.webproject.newsblog.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	private final UserDetailsService userDetailsService;

	@Autowired
	public SecurityConfig(BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsService userDetailsService) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userDetailsService = userDetailsService;
	}


	@Override
	  protected void configure(AuthenticationManagerBuilder auth)
	      throws Exception {
		  auth.userDetailsService(userDetailsService)
	          .passwordEncoder(bCryptPasswordEncoder);
	  } 
	  
	 @Override
	  protected void configure(HttpSecurity http) throws Exception {
		 
		 http.authorizeRequests()
		     .antMatchers("/login","/","/pbc/**","/registration","/spu/**","/reply/**", "/addReply").permitAll()
		     .antMatchers("/postByCreator","/addPosts", "/postStory", "/managePosts").hasAuthority("STAFF")
		     .antMatchers("/postByCreator","/single_post").hasAuthority("USER")
		     .anyRequest().authenticated()
		     .and()
		     	.formLogin()
		     			.loginPage("/login")
		     			.failureUrl("/login?error=true")
		     			.defaultSuccessUrl("/posts")
		     .and()
		     	.logout()
		     			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		     			.logoutSuccessUrl("/login")
	     	.and()
		     	.exceptionHandling()
		     	.accessDeniedPage("/access-denied");
	  }
	 
	 @Override
	 public void configure(WebSecurity webSecurity) throws Exception {
		 
		 webSecurity.ignoring()
		 			.antMatchers("/resources/**","/static/**","/css/**","/js/**","/images/**","/vendor/**");
		 
	 }
}
