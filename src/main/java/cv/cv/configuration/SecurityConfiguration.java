/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.configuration;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

/**
 *
 * @author Rayhan
 */
@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
//@EnableWebMvcSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String SELECTBYID = "select id,password,1 as enabled from user_mii where id=?";

    private static final String AUTH = "select u.id, r.name "
            + "from user_mii u join role_mii r "
            + "on r.id = u.role "
            + "where u.id=?";

    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager() throws Exception {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
        jdbcUserDetailsManager.setDataSource(dataSource);
        return jdbcUserDetailsManager;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()//setting autentikasi dari/ke database
                .usersByUsernameQuery(SELECTBYID)//untuk select user berdasarkan id
                .authoritiesByUsernameQuery(AUTH)//untuk select role yg digunakan untuk menentukan autoritas
                .dataSource(dataSource).passwordEncoder(passwordEncoder());

    }

    //Authorization
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/ForgetPassword**").permitAll()
                .antMatchers("/ResetPassword**").permitAll()
                .antMatchers("/EmpDashbord*").hasAuthority("employee")
                .antMatchers("/AdmDashboard*").hasAuthority("admin")
                .antMatchers("/RMDashboard*").hasAuthority("RM")
                .antMatchers("/ClientDashboard*").hasAuthority("client")
                .anyRequest().authenticated().and()
                .formLogin().loginPage("/login").permitAll()
                .usernameParameter("id")
                .passwordParameter("password")
                .defaultSuccessUrl("/default", true)
                .failureUrl("/login?error=true").and()
                .exceptionHandling().and()
                .logout().logoutUrl("/logout")
                .logoutSuccessUrl("/login");
        http.csrf().disable();

//      
    }

}
