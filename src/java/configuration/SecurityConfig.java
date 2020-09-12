package configuration;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    public PasswordEncoder passwordEncoder(){
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return charSequence.toString().equals(s);
            }
        };
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  /* auth.inMemoryAuthentication()
        .passwordEncoder(passwordEncoder())
                .withUser("sadeq").password(passwordEncoder().encode("sadeq")).roles("ADMIN");*/
   auth.jdbcAuthentication()
           .dataSource(dataSource).passwordEncoder(passwordEncoder())
           .usersByUsernameQuery("SELECT username,password,true from users where username=?")
            .authoritiesByUsernameQuery("SELECT username,authority from users where username=?")
   ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
        //.antMatchers("/login").anonymous()
      .antMatchers("/update/**").hasRole("ADMIN")
             //   .anyRequest().authenticated()
      .and()
       .formLogin()
        //.loginPage("/login.html")
       .defaultSuccessUrl("/update",true)
       ;
    }
}
