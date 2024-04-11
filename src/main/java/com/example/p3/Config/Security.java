package com.example.p3.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class Security {
    
    
     @Bean
    public PasswordEncoder PasswordEncoder(){
        return new BCryptPasswordEncoder();
    } 


    @Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
  http
      .authorizeHttpRequests((authz) -> authz
      .anyRequest().permitAll()
      
     
      ).csrf(AbstractHttpConfigurer::disable);
  return http.build();
}

/*
 .requestMatchers(HttpMethod.POST, "/Register").anonymous()
          .requestMatchers(HttpMethod.GET, "/Register").permitAll()
          .requestMatchers(HttpMethod.GET, "/test").permitAll()
 */
}
