package com.umss.dev.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.umss.dev.service.PruebaUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private PruebaUserService pruebaUserService;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
    private JwtFilterRequest jwtFilterRequest;
	
	@Bean
	public BCryptPasswordEncoder encoder() {
	   return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(pruebaUserService).passwordEncoder(encoder);
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers("/**/authenticate").permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				//.antMatchers("/", "/home").permitAll()
				.anyRequest().authenticated();
				//.and().httpBasic();
			//.formLogin()
				//.loginPage("/login")
				//.permitAll()
				//.and()
			//.logout()
				//.htt
	}*/
	
}
