package com.scw.kindergarten.configuration;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;

import com.sun.faces.config.ConfigureListener;

@Configuration
public class JsfConfiguration implements ServletContextAware {

	@Bean
	  public ServletRegistrationBean facesServletRegistraiton()
	  {
	    ServletRegistrationBean registration = new ServletRegistrationBean(new FacesServlet(),new String[]{"*.xhtml"});
	    registration.setName("Faces Servlet");
	    registration.setLoadOnStartup(1);
	    return registration;
	  }

	  @Bean
	  public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener()
	  {
	    return new ServletListenerRegistrationBean<>(new ConfigureListener());
	  }

	  @Override
	  public void setServletContext(ServletContext servletContext)
	  {
	    servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration",Boolean.TRUE.toString());
	    servletContext.setInitParameter("primefaces.THEME","admin");
	    servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION",Boolean.TRUE.toString());
	    servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS",Boolean.TRUE.toString());
	    servletContext.setInitParameter("primefaces.FONT_AWESOME",Boolean.TRUE.toString());
	    servletContext.setInitParameter("primefaces.UPLOADER","commons");
	  }
}
