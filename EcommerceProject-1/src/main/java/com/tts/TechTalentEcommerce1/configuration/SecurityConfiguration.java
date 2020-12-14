	    package com.tts.TechTalentEcommerce1.configuration;
	
		
	    import javax.sql.DataSource;
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.beans.factory.annotation.Value;
		import org.springframework.context.annotation.Configuration;
		import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
		import org.springframework.security.config.annotation.web.builders.HttpSecurity;
		import org.springframework.security.config.annotation.web.builders.WebSecurity;
		import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
		import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
		import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
		import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
	    import com.tts.TechTalentEcommerce1.service.UserService;

		@Configuration
		@EnableWebSecurity
		public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
		@Autowired
		private UserService userService; // not there
		
		
		@Autowired
		private BCryptPasswordEncoder bCryptPasswordEncoder;
		@Autowired
	    private DataSource dataSource;
		    @Value("${spring.queries.users-query}")
		    private String usersQuery;

		    @Value("${spring.queries.roles-query}")
		    private String rolesQuery;
		
		    @Override
		    protected void configure(AuthenticationManagerBuilder auth)
		            throws Exception {
		        auth.
		                jdbcAuthentication()
		                .usersByUsernameQuery(usersQuery)
		                .authoritiesByUsernameQuery(rolesQuery)
		                .dataSource(dataSource)
		                .passwordEncoder(bCryptPasswordEncoder);
		    }

	   		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
				 http.
				 authorizeRequests()
				 .antMatchers("/signup").permitAll()
				 .antMatchers("/console/**").permitAll()
				 .antMatchers("/").permitAll()
				 .antMatchers("/about").permitAll()
				 .antMatchers("/signin").permitAll()//signin,signup and about don't need any authentication.So.authenticated() is not wanted.
				 .antMatchers("/cart").permitAll()
				 // .antMatchers("/cart").authenticated()
				  .antMatchers("/bookstore").permitAll()
				  .antMatchers("/product").permitAll()
				 //.antMatchers("/custom.js").permitAll()
				 .antMatchers("/Style.css").permitAll()
				 .antMatchers().hasAuthority("USER").anyRequest()
				 .authenticated().and().csrf().disable().formLogin()
				 .loginPage("/Signin").failureUrl("/signin?error=true")
				 .defaultSuccessUrl("/")
				 .usernameParameter("username")
				 .passwordParameter("password")
				 .and().logout()
				 	.logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
				 	.logoutSuccessUrl("/").and().exceptionHandling();
				
				http.headers().frameOptions().disable();
				}
				
				@Override
				public void configure(WebSecurity web) throws Exception {
				web
				 .ignoring()
				 .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
				}

				public UserService getUserService() {
					return userService;
				}

				public void setUserService(UserService userService) {
					this.userService = userService;
				}
				}

                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
// //        authorizeRequests()
////         .antMatchers("/cart").authenticated()
////          .and().formLogin()
////          .loginPage("/signin")
////         .loginProcessingUrl("/login")
////          .and().logout()
////          .logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
////          .logoutSuccessUrl("/");
////				.antMatchers("/console/**").permitAll()
////				.antMatchers("/signin").permitAll()
////				.antMatchers("/signup").permitAll()
////				.antMatchers("/").permitAll()
////				.antMatchers("/product").permitAll()
////				.antMatchers("/product/{id}").permitAll()
////				.antMatchers("/cart").permitAll()
////				.antMatchers("/resources/**", "/static/**",  "/images/**").permitAll()
////				.antMatchers().hasAuthority("USER").anyRequest()
////				.authenticated().and().csrf().disable().formLogin()
////				.loginPage("/signin").failureUrl("/signin?error=true")
////				
////				
////				//.antMatchers().hasAuthority("USER").anyRequest()
////				//.authenticated().and().csrf().disable().formLogin()
////				//.loginPage("/signin")
////				//.loginProcessingUrl("/login")
////				
////				.defaultSuccessUrl("/products")
////				.usernameParameter("username")
////				.passwordParameter("password")
////				
////				
////				.and().logout()
////				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
////				.logoutSuccessUrl("/").and().exceptionHandling();
////				
////				http.headers().frameOptions().disable();
////				
////				}
////				@Override
////				public void configure(WebSecurity web) throws Exception {
////				web
////				        .ignoring()
////				        .antMatchers("/resources/**", "/static/**",  "/images/**");
////				}     
////				}



