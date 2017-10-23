package server.example.server.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
      .antMatchers("/").hasRole("USER")
      .anyRequest().fullyAuthenticated()
      .and().httpBasic()
      .and().csrf().disable();

  }


  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

    auth
      .inMemoryAuthentication()
      .withUser("gaurang").password("fibo1234").roles("USER");
  }
}