package com.luv2code.claimedit.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
       http.authorizeHttpRequests(
                        configurer ->
                                configurer
                                       // .requestMatchers("/leader").hasRole("Manager")
                                        //.requestMatchers("/employee").hasRole("Employee")
                                        .requestMatchers("/showMyLoginForm", "/logout").permitAll()
                                        .anyRequest().authenticated()
                ).
                formLogin(
                        form ->
                                form.loginPage("/showMyLoginForm")
                                        .loginProcessingUrl("/authenticateTheUser")
                                        .permitAll()
                ).
                exceptionHandling(
                        exception ->
                                exception.accessDeniedPage("/accessDenied")).

                logout( logout-> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                )
               .sessionManagement(session -> session .invalidSessionUrl("/showMyLoginForm?invalid-session=true"));

       return http.build();
    }
}
