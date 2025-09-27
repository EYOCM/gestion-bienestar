/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author JAED07
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
      .csrf(csrf -> csrf.disable()) // evita 403 al hacer POST desde Postman
      .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
            
            /*
        // Deja libre el registro de clientes (UC-01)
        .requestMatchers("/api/clientes/**").permitAll()
        // Todo lo demás requiere autenticación
        .anyRequest().authenticated()
      )
      // Asegura que Basic Auth esté habilitado
      .httpBasic(h -> {});
*/
    return http.build();
  }
}