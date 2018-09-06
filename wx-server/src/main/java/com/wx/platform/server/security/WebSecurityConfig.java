package com.wx.platform.server.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    SessionRegistry sessionRegistry;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CookieCsrfTokenRepository csrfTokenRepository = CookieCsrfTokenRepository.withHttpOnlyFalse();
        csrfTokenRepository.setCookieHttpOnly(true);
        http
                .formLogin()
                .defaultSuccessUrl("/", true)
                .loginPage("/login").loginProcessingUrl("/login").permitAll()
                .successHandler(userAuthenticationSuccessHandler())
                .failureHandler(userAuthenticationFailureHandler())
                .and()
                .authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/fonts/**").permitAll()
                .antMatchers("/img/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/l10n/**").permitAll()
                .antMatchers("/tbl/**").permitAll()
                .antMatchers("/vendor/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().csrfTokenRepository(csrfTokenRepository)
                .and()
                .sessionManagement()
                .invalidSessionUrl("/signin")
                .maximumSessions(-1)
                .sessionRegistry(sessionRegistry)
                .and()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                //.logoutSuccessHandler(userLogoutSuccessHandler())
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .authenticationProvider(userAuthenticationProvider())
                .userDetailsService(userAuthDetailsService());
    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public UserAuthenticationProvider userAuthenticationProvider() {
        return new UserAuthenticationProvider();
    }

    //@Bean
//    public AuthenticationManager authenticationManager() {
//        return new UserAuthenticationManager();
//    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Bean
    public UserAuthDetailsService userAuthDetailsService() {
        return new UserAuthDetailsService();
    }

    @Bean
    public UserAuthenticationSuccessHandler userAuthenticationSuccessHandler() {
        return new UserAuthenticationSuccessHandler();
    }

    @Bean
    public UserAuthenticationFailureHandler userAuthenticationFailureHandler() {
        return new UserAuthenticationFailureHandler();
    }

    @Bean
    public UserLogoutSuccessHandler userLogoutSuccessHandler() {
        return new UserLogoutSuccessHandler();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被拦截的问题
        web.ignoring()
                .antMatchers("/css/**")
                .antMatchers("/fonts/**")
                .antMatchers("/img/**")
                .antMatchers("/js/**")
                .antMatchers("/l10n/**")
                .antMatchers("/tbl/**")
                .antMatchers("/vendor/**");
    }

}
