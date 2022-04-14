package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.filter.CustomAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	private static final String GET ;
//	private static final String POST ;
	@Autowired
 	private UserDetailsService userDetailsService;
 	@Autowired
 	private PasswordEncoder bCryptPasswordEncoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable()
				// .exceptionHandling().authenticationEntryPoint(jwtUnAuthorizedResponseAuthenticationEntryPoint).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.authorizeRequests()
	            .antMatchers("/login/**").permitAll()
				.antMatchers("/api/**").authenticated()
//				.antMatchers( "/api/utilisateur/effectuer/**").hasAnyAuthority("ROLE_APIKEY1")
				.anyRequest().authenticated();

		http.addFilter(new CustomAuthenticationFilter(authenticationManagerBean()));

//		http   .csrf().disable();
		// http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//           http.authorizeRequests().anyRequest().authenticated();
//           http.authorizeRequests().antMatchers(GET, "/api/utilisateur/**").hasAnyAuthority("ROLE_UTILISATEUR");
//           http.authorizeRequests().antMatchers(POST, "/api/utilisateur/effectuer/**").hasAnyAuthority("ROLE_APIKEY1");
//	http.addFilter(new CustomAuthenticationFilter(authenticationManagerBean()));
//		   

	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
