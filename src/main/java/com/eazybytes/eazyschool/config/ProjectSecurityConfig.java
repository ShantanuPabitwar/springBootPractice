package com.eazybytes.eazyschool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> {
            requests
                    .requestMatchers("/", "/home").permitAll()
                    .requestMatchers("/contact").permitAll()
                    .requestMatchers("/holidays/**").permitAll()
                    .requestMatchers("/assets/**").permitAll()
                    .requestMatchers("/saveMsg").permitAll()
                    .requestMatchers("/courses").authenticated();
        });
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        return (SecurityFilterChain)http.build();
    }

    @Bean
    InMemoryUserDetailsManager userDetailsManager() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .password("1234")
                .roles("USER")
                .username("user").build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .password("5678")
                .roles("USER", "ADMIN")
                .username("admin").build();

        return  new InMemoryUserDetailsManager(user, admin);
    }
}

