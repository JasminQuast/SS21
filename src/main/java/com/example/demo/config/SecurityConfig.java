package com.example.demo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

import java.net.URI;

@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

//    ClientRegistrationRepository clientRegistrationRepository;
//
//    OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler() {
//        OidcClientInitiatedLogoutSuccessHandler successHandler = new OidcClientInitiatedLogoutSuccessHandler(clientRegistrationRepository);
//        successHandler.setPostLogoutRedirectUri(URI.create("http://localhost:8080/login/oauth2/code/okta"));
//        return successHandler;
//    }

    @Autowired
    ClientRegistrationRepository clientRegistrationRepository;

    OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler() {
        OidcClientInitiatedLogoutSuccessHandler successHandler = new OidcClientInitiatedLogoutSuccessHandler(clientRegistrationRepository);
        successHandler.setPostLogoutRedirectUri(URI.create("http://localhost:8080/"));
        return successHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()

                // allow anonymous access to the root page
                .antMatchers(
                        Endpoints.Site.SLASH,
                        Endpoints.Site.DIARYST
                ).permitAll()
                .antMatchers(
                        "/css/**",
                        "/images/**",
                        "/js/**")
                .permitAll()

                // all other requests
                .anyRequest().authenticated().and().exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler())
                .and().oauth2Login()

                .and()

                // RP-initiated logout
                .logout().logoutSuccessHandler(oidcLogoutSuccessHandler());

    }
//        http.authorizeRequests().anyRequest().authenticated().and().oauth2Login()
//                .and().csrf().disable();
//    }
}
//
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    ClientRegistrationRepository clientRegistrationRepository;
//
//    OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler() {
//        OidcClientInitiatedLogoutSuccessHandler successHandler = new OidcClientInitiatedLogoutSuccessHandler(clientRegistrationRepository);
//        successHandler.setPostLogoutRedirectUri(URI.create("http://localhost:8080/"));
//        return successHandler;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers(
//                        HttpMethod.GET,
//                        Endpoints.Site.DIARYST,
//                        Endpoints.Site.SLASH,
//                        Endpoints.Site.LOGIN,
//                        Endpoints.Site.REGISTER
//                ).permitAll()
//                .antMatchers(
//                        "/css/**",
//                        "/images/**",
//                        "/js/**")
//                .permitAll()
//                .anyRequest().authenticated()
//                .and()
//
//                .logout().logoutSuccessUrl("/")
//
//                // RP-initiated logout
//                .and().logout().logoutSuccessHandler(oidcLogoutSuccessHandler())
//                .and()
//                .oauth2Client()
//                .and()
//                .oauth2Login();
//    }
//}

