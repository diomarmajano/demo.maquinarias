
package com.maquinarias.demo.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

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
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/").permitAll()
                .requestMatchers("contacto").permitAll()
                .requestMatchers("registro").permitAll()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/maquinarias").authenticated()
                .requestMatchers("home").authenticated()
                .requestMatchers("/**.css").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin((form) -> form
                .loginPage("/login") 
                .loginProcessingUrl("/login") 
                .defaultSuccessUrl("/home", true)
                .permitAll() 
            )
            .logout((logout) -> logout
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                    .permitAll())

            .headers(headers -> headers
                .contentSecurityPolicy(csp -> csp
                    .policyDirectives(
            "default-src 'self'; " +
            "img-src 'self' https://www.deere.com data:; " +
            "style-src 'self' 'unsafe-inline'; " +
            "script-src 'self'; " +
            "font-src 'self' https://fonts.googleapis.com https://fonts.gstatic.com; " +
            "connect-src 'self'; " +
            "frame-ancestors 'none';"
        )
        )
            );
        return http.build();
    }
}
