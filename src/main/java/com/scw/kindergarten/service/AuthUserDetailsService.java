package com.scw.kindergarten.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.scw.kindergarten.model.Rola;
import com.scw.kindergarten.model.Uprawnienie;
import com.scw.kindergarten.model.Uzytkownik;
import com.scw.kindergarten.repository.UzytkownikRepository;

@Service
public class AuthUserDetailsService implements UserDetailsService {

	@Autowired
	private UzytkownikRepository uzytkownikRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		Uzytkownik uzytkownik = uzytkownikRepository.findByEmail(userName);

		User userdetails = new User(uzytkownik.getNazwisko(), uzytkownik.getHaslo(), uzytkownik.getOdblokowany(),
				accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthorities(uzytkownik.getRola()));

		return userdetails;
	}

	private Collection<? extends GrantedAuthority> getAuthorities(Collection<Rola> role) {
		return getGrantedAuthorities(getPrivileges(role));
	}

	private List<String> getPrivileges(Collection<Rola> role) {

		List<String> privileges = new ArrayList<>();
		List<Uprawnienie> collection = new ArrayList<>();
		for (Rola rola : role) {
			collection.addAll(rola.getUprawnienie());
		}
		for (Uprawnienie item : collection) {
			privileges.add(item.getNazwaUprawnienia());
		}
		return privileges;
	}

	private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (String privilege : privileges) {
			authorities.add(new SimpleGrantedAuthority(privilege));
		}
		return authorities;
	}
}
