package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
// @formatter:off
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  UserDetailsService userDetailsService;

  // Define your users and their roles here
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    DaoAuthenticationProvider provider = new DaoAuthenticationProvider(); 
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    provider.setUserDetailsService(userDetailsService);
    provider.setPasswordEncoder(encoder);

    auth
      .authenticationProvider(provider);
  }

  protected void configure(HttpSecurity http) throws Exception {
    http
      .formLogin()
        .and()
      .authorizeRequests()
        .antMatchers("/**")
        .authenticated()
        .and()
      .logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/");
  }

}
// @formatter: on