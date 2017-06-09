package com.scw.kindergarten.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

@Component("testBean")
@ViewScoped
public class TestBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
    private HelloService helloSrv;
	
	@Autowired
    private Redirector redirector;
    private int counter;

    @PostConstruct
    private void init() {
        counter = 1;
    }

    /*
     * actions
     */
    public void inc() {
        counter++;
    }

    public void nextPage() throws IOException {
        redirector.redirect("nextpage.jsf");
    }

    public void prevPage() throws IOException {
        redirector.redirect("index.jsf");
    }

    public String getSrvMsg() {
        return helloSrv.getHelloMsg();
    }

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

}
