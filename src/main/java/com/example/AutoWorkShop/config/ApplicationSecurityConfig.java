package com.example.AutoWorkShop.config;

import com.example.AutoWorkShop.service.impl.AutoWorkShopUserService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AutoWorkShopUserService autoWorkShopUserService;
    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfig(AutoWorkShopUserService autoWorkShopUserService,
                                     PasswordEncoder passwordEncoder) {

        this.autoWorkShopUserService = autoWorkShopUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
//                .antMatchers("/js/**", "/css/**", "/images/**")
                .permitAll()
                .antMatchers("/", "/users/login/**", "/users/register/**")
                .permitAll()
                .antMatchers("/orders/**", "/cars/**", "/users/**", "/home/**")
                .hasRole("USER")
                .antMatchers("/**").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/users/login")
                .usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                .passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY)
                .defaultSuccessUrl("/home")
                .failureForwardUrl("/users/login-error")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(autoWorkShopUserService)
                .passwordEncoder(passwordEncoder);
    }
}
