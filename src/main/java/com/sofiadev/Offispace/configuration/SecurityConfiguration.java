package com.sofiadev.Offispace.configuration;

import com.sofiadev.Offispace.exception.CustomAccessDeniedHandler;
import com.sofiadev.Offispace.exception.CustomAuthenticationEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final UserDetailsService userDetailsService;

    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    @Autowired
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        // PÚBLICO
                        .requestMatchers(
                                "/auth/**",
                                "/h2-console/**",
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/swagger-ui.html"
                        ).permitAll()
                        .requestMatchers(HttpMethod.GET,
                                "/spaces/**",
                                "/reviews",
                                "/reviews/space/**",
                                "/categories/**",
                                "/features/**"
                        ).permitAll()

                        // SOLO ADMIN
                        .requestMatchers("/auth/admin-only").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/spaces/**", "/categories/**", "/features/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/spaces/**", "/categories/**", "/features/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/spaces/**", "/categories/**", "/features/**").hasRole("ADMIN")

                        // SOLO USER
                        .requestMatchers("/user/**").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/reviews/**", "/favorites/**", "/reservations/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/reviews/**", "/favorites/**", "/reservations/**").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/reviews/**").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/reviews/**", "/favorites/**", "/reservations/**").hasRole("USER")

                        // CUALQUIER OTRO
                        .anyRequest().authenticated()
                )
                .headers(headers -> headers.frameOptions(frame -> frame.disable()))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(e -> e
                        .authenticationEntryPoint(customAuthenticationEntryPoint)
                        .accessDeniedHandler(customAccessDeniedHandler))
                .build();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
