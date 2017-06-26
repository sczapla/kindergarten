package com.scw.kindergarten.view;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component("jezyk")
@SessionScope
public class ZmianaJezyka implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

  public void setLanguage(String language)
  {
    if (locale.getLanguage().equals(new Locale("pl").getLanguage()))
    {
      locale = new Locale("en");
    }
    else
    {
      locale = new Locale("pl");
    }
    FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
  }

  public void buttonAction(ActionEvent actionEvent)
  {
    addMessage("Welcome to Primefaces!!");
    //setLanguage("sad");
  }
  public void showMsg(){
	  addMessage("Welcome to Primefaces!!");
  }
  public void addMessage(String summary)
  {
    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,summary,null);
    FacesContext.getCurrentInstance().addMessage(null,message);
  }
}
