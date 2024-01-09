package com.gestion.empleados.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	 //Configuración de seguridad HTTP
	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())   // Desactiva la protección CSRF
                .authorizeRequests(requests -> requests
                        .antMatchers("/empleados/admin").hasRole("ADMIN")
                        .antMatchers("/empleados/user").hasRole("USER")
                        .antMatchers("/api/usuarios/basicauth").hasAnyRole("USER", "ADMIN"))
                .formLogin(login -> login
                        .loginPage("/login") // Especifica la página de inicio de sesión personalizada
                        .permitAll())
                .httpBasic(withDefaults()); // Configura la autenticación básica HTTP
	}

    
    
    /*La falsificación de solicitud entre sitios @(CSRF) 
     * es un tipo de ataque que ocurre cuando un usuario malintencionado 
     * engaña a una víctima para que envíe una solicitud a una aplicación 
     * web en la que está conectado.*/

    
    
    // Configuración de autenticación global (usuarios en memoria con roles y contraseñas encriptadas usando BCrypt)
    // @configure(AuthenticationManagerBuilder) Para definir cómo se autenticarán los usuarios
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN")
            .and()
            .withUser("user").password(passwordEncoder().encode("user123")).roles("USER");
    }
    
    
    // Configuración de un bean para el encriptador de contraseñas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Devuelve un encriptador de contraseñas basado en BCrypt
        
    }
}


/*BCryptPasswordEncoder, que utiliza el algoritmo de hashing BCrypt para encriptar contraseñas.
 *  Al utilizar un PasswordEncoder, incluso si la base de datos es comprometida, 
 *  las contraseñas no serán fácilmente recuperables.*/

