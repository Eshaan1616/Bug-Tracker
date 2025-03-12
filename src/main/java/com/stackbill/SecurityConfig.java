package com.stackbill;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfToken;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.filter.OncePerRequestFilter;


//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRessponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { 
  	http
  	    .csrf(csrf -> csrf.disable())
  	    .cors(cors -> cors.disable())
  	    .securityMatcher("/**")
  	    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.authorizeHttpRequests((authorizeHttpRequests) ->
		 authorizeHttpRequests
//		  .requestMatchers(HttpMethod.GET, "/api/**").permitAll()
		    .requestMatchers("/").permitAll()
//		    .requestMatchers("/api/**").permitAll()
		    .anyRequest().permitAll()
// 			.requestMatchers(HttpMethod.POST, "/api/user").permitAll()
// 			.requestMatchers(HttpMethod.PUT, "/api/user").permitAll()
// 			.requestMatchers(HttpMethod.DELETE, "/api/user").permitAll()
 		//	.requestMatchers("/api/user/**").hasRole("USER")



// 			.requestMatchers("/**").hasRole("USER")
// 			.requestMatchers("/**").hasRole("USER")
// 			.requestMatchers("/**").hasRole("USER")
 			
		);
//     	
	 
      // Custom filter to log CSRF token
//      http.addFilterAfter(new CsrfTokenLoggerFilter(), org.springframework.security.web.csrf.CsrfFilter.class);
//
      return http.build();
                           }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("spring")
            .password("{noop}secret")
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }

//    private static class CsrfTokenLoggerFilter extends OncePerRequestFilter {
//    	@Override
//		protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request,
//				jakarta.servlet.http.HttpServletResponse response, jakarta.servlet.FilterChain filterChain)
//				throws jakarta.servlet.ServletException, IOException {
//            CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
//            if (csrfToken != null) {
//                System.out.println("CSRF Token: " + csrfToken.getToken());
//            }
//            filterChain.doFilter(request, response);
//        }

		
			// TODO Auto-generated method stub
			
		//}
    }





//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.csrf.CsrfToken;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    	http
//		.authorizeHttpRequests((authorizeHttpRequests) ->
//		 authorizeHttpRequests
//   			.requestMatchers("/**").hasRole("USER")
//		)
//		.formLogin(withDefaults());
//	return http.build();
//
//        // Custom filter to log CSRF token
//        http.addFilterAfter(new CsrfTokenLoggerFilter(), org.springframework.security.web.csrf.CsrfFilter.class);
//
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.withUsername("spring")
//            .password("{noop}secret")
//            .roles("USER")
//            .build();
//        return new InMemoryUserDetailsManager(user);
//    }
//
//    private static class CsrfTokenLoggerFilter extends OncePerRequestFilter {
//        @Override
//        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//                throws ServletException, IOException {
//            CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
//            if (csrfToken != null) {
//                System.out.println("CSRF Token: " + csrfToken.getToken());
//            }
//            filterChain.doFilter(request, response);
//        }
//    }
//}







//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {


//	    @Bean
//	    public InMemoryUserDetailsManager userDetailsService() {
//	        UserDetails user = User.withUsername("spring")
//	            .password("{noop}secret")
//	            .roles("USER")
//	            .build();
//	        return new InMemoryUserDetailsManager(user);
//	    }
//	}
//	
	


//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests((authz) -> authz
//                .anyRequest().authenticated()
//            )
//            .httpBasic(withDefaults())
//            .authenticationManager(new CustomAuthenticationManager());
//        return http.build();
//    }
//
//}




//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http
//			.authorizeHttpRequests((authorizeHttpRequests) ->
//				authorizeHttpRequests
//					.requestMatchers("/**").hasRole("USER")
//			)
//			.formLogin(withDefaults());
//		return http.build();
//	}
//
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails user = User.withDefaultPasswordEnco()
//			.username("user")
//			.password("password")
//			.roles("USER")
//			.build();
//		UserDetails admin = User.withDefaultPasswordEncoder()
//			.username("admin")
//			.password("password")
//			.roles("ADMIN", "USER")
//			.build();
//		return new InMemoryUserDetailsManager(user, admin);
//	}
//}
