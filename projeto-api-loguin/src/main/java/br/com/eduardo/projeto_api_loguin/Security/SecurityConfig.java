package br.com.eduardo.projeto_api_loguin.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST,"/usuarios/login").permitAll()
                        .requestMatchers(HttpMethod.POST,"/usuarios").permitAll()
                        .anyRequest().authenticated()
                );

        http.addFilterBefore(new securityFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
