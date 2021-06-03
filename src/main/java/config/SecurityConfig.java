package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(
                        HttpMethod.GET,
                        Endpoints.Site.DIARYST,
                        Endpoints.Site.SLASH,
                        Endpoints.Site.LOGIN,
                        Endpoints.Site.REGISTER
                ).permitAll()
                .antMatchers(
                        "/css/**",
                        "/images/**",
                        "/js/**")
                .permitAll()
                .anyRequest().authenticated()
                .and()
//                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logout().logoutSuccessUrl("/")
                .and()
                .oauth2Client()
                .and()
                .oauth2Login();
    }
}


