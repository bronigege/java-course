package io.dumasoft.library.configuration;

import io.dumasoft.library.auth.LoginSuccessHandler;
import io.dumasoft.library.service.admin.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {
    private UserService userService;
    private LoginSuccessHandler successHandler;

    public SpringSecurityConfig(
            UserService userService,
            LoginSuccessHandler successHandler
    ) {
        this.userService = userService;
        this.successHandler = successHandler;
    }

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests(requests -> requests
                        .requestMatchers("/", "/css/**", "/js/**", "/images/**", "/images/***", "/login", "/upload/**").permitAll()
                        //.requestMatchers("/api/v1/book/save", "/api/v1/editorial/save").hasRole("")
                )
                .formLogin(login -> login
                        .loginPage("/login")
                        .successHandler(successHandler)
                        .defaultSuccessUrl("/", true)
                        .failureUrl("/login?error=true")
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                )
        ;

        return httpSecurity.build();
    }

    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder
                .userDetailsService(userService)
                .passwordEncoder(passwordEncoder());
    }
}
