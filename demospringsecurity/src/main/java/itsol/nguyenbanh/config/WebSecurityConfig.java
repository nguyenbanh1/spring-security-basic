package itsol.nguyenbanh.config;

import itsol.nguyenbanh.demospringsecurity.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/get/private/user/*").hasRole("USER")
                .antMatchers("/get/admin/*").hasRole("ADMIN")
                .antMatchers("/get/home").permitAll()
                .antMatchers("/staffs/all").permitAll()
                .antMatchers("/staff_roles").hasRole("ADMIN")
                .antMatchers("/roles").hasRole("ADMIN")
                .and().httpBasic();
    }



    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder  auth) throws Exception{

//        auth.inMemoryAuthentication()
//                .withUser("nguyen").password("{noop}password").roles("USER")
//                .and()
//                .withUser("nguyenbanh").password("{noop}password").roles("USER","ADMIN")
//                .and()
//                .withUser("nguyen123").password("{noop}password").roles("USER");


        auth.userDetailsService(customUserDetailsService)
                .passwordEncoder(getPassEncoder());



    }

    @Bean
    public PasswordEncoder getPassEncoder(){
        return new BCryptPasswordEncoder();
    }


}
























