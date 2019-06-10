package com.mars.edu.web.config;

import com.mars.edu.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * create by: Chris Chan
 * create on: 2019/6/7 23:32
 * use for:
 */
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MarsSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("chris").password(passwordEncoder().encode("123456")).roles("ADMIN", "USER")
                .and()
                .withUser("cc").password(passwordEncoder().encode("12345")).roles("ADMIN", "USER");
        //auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS, "/**")
                .antMatchers("/v2/**")
                .antMatchers("/swagger-resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/login.html").permitAll()
                .loginProcessingUrl("/user/login").permitAll()
                .and()
                .logout().logoutUrl("/logout").permitAll().logoutSuccessUrl("/login.html")
                .and()
                .authorizeRequests()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/role/**").permitAll()
                .antMatchers("/swagger-ui.html").permitAll()
                //.anyRequest().authenticated()
                .and()
                .csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
