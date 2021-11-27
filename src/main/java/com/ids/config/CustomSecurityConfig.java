package com.ids.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class CustomSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;

	@Autowired
	private UserDetailsService userDetailsService;

    @Override
    public void configure(WebSecurity web) {
        web
            .ignoring()
//            .antMatchers(HttpMethod.OPTIONS, "/**")
//            .antMatchers("/app/**/*.{js,html}")
//            .antMatchers("/i18n/**")
//            .antMatchers("/content/**")
            .antMatchers("/swagger-ui/**", "/swagger-resources/**", "/v3/api-docs")
//            .antMatchers("/test/**")
        ;
    }
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/article/**").hasAnyAuthority("BO", "USER")
				.antMatchers("/client/**").hasAnyAuthority("USER")
				.antMatchers("/facture/**").hasAnyAuthority("ADMIN")
				.anyRequest().authenticated()
			.and().formLogin()
		;
//		http.authorizeRequests()
//		.antMatchers("/admin/**").hasAuthority("ADMIN")
//		.antMatchers("/user").hasAuthority("USER")
//		.antMatchers("/bo").hasAnyAuthority("BO", "ADMIN")
//		.antMatchers("/auth").authenticated()
//		.anyRequest().permitAll()
//		.and().formLogin()
//		;
	}

	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//				.withUser("user").password("pass").authorities("USER")
//			.and()
//				.withUser("admin").password("pass").authorities("ADMIN", "BO", "USER")
//			.and()
//				.withUser("bo").password("pass").authorities("BO")
//		;
//	}
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication().dataSource(dataSource)
////				.withDefaultSchema()
////				.withUser(User.withUsername("admin").password("pass").authorities("ADMIN"))
////				.withUser(User.withUsername("user").password("pass").authorities("USER"))
//			.usersByUsernameQuery("select username, password, enabled from jdbc_users where username = ?")
//			.authoritiesByUsernameQuery("select username, authority from jdbc_authorities where username = ?")
//		;
//	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}
