package pl.niepracuj.configration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/adv/create", "/company/create",
                        "/level/create", "/senoiority/create", "/technology/create").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.GET,"/**").permitAll()
                .anyRequest().permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();

    }
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailsService);
    }
}
