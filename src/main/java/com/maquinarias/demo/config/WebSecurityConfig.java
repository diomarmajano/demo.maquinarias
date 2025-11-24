
package com.maquinarias.demo.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.maquinarias.demo.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    //cramos una constante para evitar la duplicidad del literal 
    private static final String LOGIN_URL = "/login";

   @Bean
    public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(
            HttpSecurity http,
            PasswordEncoder encoder,
            CustomUserDetailsService userDetailsService) throws Exception {

        AuthenticationManagerBuilder auth =
                http.getSharedObject(AuthenticationManagerBuilder.class);

        auth.userDetailsService(userDetailsService)
            .passwordEncoder(encoder);

        return auth.build();
    }

    //Aca creamo el Bean para la configuracion de Cross-Domain
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList(
            "http://localhost:8080",
            "https://www.deere.com"
        ));
        config.setAllowedMethods(Arrays.asList("GET", "POST"));
        config.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        config.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); 
        return source;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors(Customizer.withDefaults())
            .authorizeHttpRequests(requests -> requests
                .requestMatchers("/").permitAll()
                .requestMatchers("contacto").permitAll()
                .requestMatchers("registro").permitAll()
                .requestMatchers(LOGIN_URL).permitAll()
                .requestMatchers("/maquinarias").authenticated()
                .requestMatchers("home").authenticated()
                .requestMatchers("/**.css").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage(LOGIN_URL) 
                .loginProcessingUrl(LOGIN_URL) 
                .defaultSuccessUrl("/home", true)
                .permitAll() 
            )
            .logout(logout -> logout
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                    .permitAll())

    .headers(headers -> headers
        .contentSecurityPolicy(csp -> csp
            .policyDirectives(
            "default-src 'self'; " +
            "script-src 'self'; " +
            "style-src 'self'; " +
            "img-src 'self' https://www.deere.com; " +
            "font-src 'self'; " +
            "connect-src 'self'; " +
            "form-action 'self'; " +
            "object-src 'none'; " +
            "frame-ancestors 'none'; " +
            "base-uri 'self'; " +
            "frame-src 'none';"
            )
        )
    );
        return http.build();
    }
}

