package net.javaguides.todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf((csrf) -> {
            try {
                csrf.disable().authorizeHttpRequests((authorize) -> { // authorizeHttpRequests to authorize all incoming http requests
                    authorize.anyRequest().authenticated(); // all incoming requests are authenticated using anyRequest().authenticated()
                }).httpBasic(Customizer.withDefaults());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return httpSecurity.build();
    }
}
