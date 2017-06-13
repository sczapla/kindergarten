package com.scw.kindergarten.view;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component("logonMB")
@Scope("session")
public class LogonMB {
	public String getCurrentUser() {
		String userName = "";
		Object contextUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (contextUser instanceof User) {
			userName = ((User) contextUser).getUsername();
		} else if (contextUser instanceof String) {
			userName = (String) contextUser;
		}
		return userName;
	}
}
