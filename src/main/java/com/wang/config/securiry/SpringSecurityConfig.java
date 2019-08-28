//package com.wang.config.securiry;
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
//import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
//
//
//@Configuration
//@EnableWebSecurity
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
//	
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		// TODO Auto-generated method stub
//		super.configure(web);
//		
//	}
//
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		super.configure(auth);
//		//auth.inMemoryAuthentication().withUser("wsl").password(passwordEncoder().encode("123")).roles("USER").authorities("ROLE_LIST","ROLE_UPDATE");
//	}
//
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		//super.configure(http);
//		http.authorizeRequests()
//        //需要权限的页面
//      // .antMatchers("/product/list").hasAnyAuthority("ROLE_"+PermissionEnum.DELETE)
//        
//      //  允许所有用户访问的资源
//        .antMatchers("/","/index").permitAll()
//       //其他资源被拦截
//        .anyRequest().authenticated()  // 任何请求,登录后可以访问
//        .antMatchers("/**").fullyAuthenticated();
//	}
//	 /**
//     * 自定义UserDetailsService，授权
//     * @return
//     */
//    @Bean
//    public CustomUserDetailService customUserDetailService(){
//        return new CustomUserDetailService();
//    }
//}
