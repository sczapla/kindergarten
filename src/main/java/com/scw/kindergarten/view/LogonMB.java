package com.scw.kindergarten.view;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component("logonMB")
@Scope("session")
public class LogonMB
{
  public String getCurrentUser()
  {
    User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return user.getUsername();
  }
}
