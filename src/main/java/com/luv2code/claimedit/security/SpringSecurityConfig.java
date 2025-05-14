package com.luv2code.claimedit.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

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
                                        .defaultSuccessUrl("/searchPatientClaims", true)
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

    /*@Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        UserDetails user1 = User.builder()
                .username("admin")
                .password(encoder.encode("admin123"))
                .roles("ADMIN")
                .build();

        UserDetails user2 = User.builder()
                .username("user")
                .password(encoder.encode("user123"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);

    }

}
