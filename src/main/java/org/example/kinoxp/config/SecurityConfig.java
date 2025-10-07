package org.example.kinoxp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// This class will load and configure the application's configurations'
// It will be executed when the application starts and before any other beans are created
// like Service or Repository
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    // !!! Explanation of PasswordEncoder !!!
    // reference for this explanation:
    // https://www.baeldung.com/spring-security-registration-password-encoding-bcrypt
    /*
     * BCrypt, however, will internally generate a random salt instead.
     * This is important to understand because it means that each call will have a different result,
     * so we only need to encode the password once.
     * To make this random salt generation work,
     * BCrypt will store the salt inside the hash value itself.
     * For instance, the following hash value:
     * $2a$10$ZLhnHxdpHETcxmtEStgpI./Ri1mksgJ9iDP36FmfMdYyVg9g0b2dq
     * The “2a” represents the BCrypt algorithm version
     * The “10” represents the strength of the algorithm
     * The “ZLhnHxdpHETcxmtEStgpI.” part is actually the randomly generated salt.
     * Basically, the first 22 characters are salt.
     * The remaining part of the last field is the actual hashed version of the plain text.
     * */

    // If we want to use BCrypt, we need to create a bean for it
    // Just like when we create a bean for our Repositories and Services
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Be aware that the BCrypt algorithm generates a String of length 60,
        // so we need to make sure that the password will be stored in a column that can
        // accommodate it
        return new BCryptPasswordEncoder();
    }

    // Explanation of SecurityFilterChain:
    // https://www.baeldung.com/spring-security-url-http-authorization
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Stateless session (tokenbased authentication)
        // disable CRSF (cross site request forgery) protection
        // which is typically done for stateless APIs or during development
        http.sessionManagement(c ->
                        // disable session
                        c.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(AbstractHttpConfigurer::disable)
                // Here we can configure the security rules for our RestControllers
                .authorizeHttpRequests(c ->
                        // We just allow all
                        c.anyRequest().permitAll()

                        // !!! EXAMPLES !!!
                        // Get all users needs to be authenticated
                        //.requestMatchers(HttpMethod.GET,"/admin/users")
                        // Any other request to any of our RestControllers needs to be authenticated
                        //.anyRequest().authenticated()
                );

        // build rules
        return http.build();
    }


}
