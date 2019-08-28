//package com.wang.config.securiry;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import com.wang.model.UserInfo;
//import com.wang.service.UserInfoService;
//
///**
// *  自定义UserDetailsService
// * @author Administrator
// *
// */
//@Component
//public class CustomUserDetailService implements UserDetailsService{
//	@Autowired
//	private UserInfoService userService;
////	@Autowired
////	private PasswordEncoder passwordEncoder;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		UserInfo userInfo = userService.findByOpenId(username);
//		if(userInfo == null) {
//			throw new UsernameNotFoundException("not found");
//		}
//		//定义权限列表
//		List<GrantedAuthority> authorities = new ArrayList<>();
//		 // 用户可以访问的资源名称（或者说用户所拥有的权限） 注意：必须"ROLE_"开头
//		authorities.add(new SimpleGrantedAuthority("ROLE_"+userService.findPermissionByUserId(username)));
//		User userDetails = new User(userInfo.getUserId(), userInfo.getPassword(), authorities);
//		return userDetails;
//	}
//
//}
