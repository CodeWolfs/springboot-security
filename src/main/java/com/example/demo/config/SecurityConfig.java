package com.example.demo.config;

import com.example.demo.service.impl.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName SecurityConfig
 * @Description TODO
 * @Author WangZhe
 * @Date 2022/4/14 14:40
 * @Version 1.0
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailService myUserDetailService;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccess.html");

        http.exceptionHandling().accessDeniedPage("/unauth.html");

        http.formLogin()
                .loginPage("/login.html") // 登录页面
                .loginProcessingUrl("/user/login") //表单登录按钮路径
                .defaultSuccessUrl("/test/index") //登录成功的默认跳转路径
                .and().authorizeHttpRequests()
                .antMatchers("/hello", "/user/login", "/login.html","logoutSuccess.html").permitAll() //放行路径,需要添加登录页面到放行路径中
                .antMatchers("/test/authority").hasAuthority("admin")
                .antMatchers("/test/authorities").hasAnyAuthority("admin", "girl")
                .antMatchers("/test/authority").hasRole("producer")
                .antMatchers("/test/authorities").hasAnyRole("producer", "consumer")
                .anyRequest().authenticated()
                .and().csrf().disable();//关闭csrf 防护

    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
