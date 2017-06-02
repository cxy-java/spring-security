package com.security.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * 登陆校验
 * 
 * @author Qutke
 *
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority("add");
		SimpleGrantedAuthority authorityUser = new SimpleGrantedAuthority("user");
		authorities.add(authority);
		authorities.add(authorityUser);
		return new User(username, "123456", true, // 是否可用
				true, // 是否过期
				true, // 证书不过期为true
				true, // 账户未锁定为true
				authorities);
	}

}
