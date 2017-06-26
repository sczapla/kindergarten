package com.scw.kindergarten.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.timeline.TimelineEvent;
import org.primefaces.model.timeline.TimelineModel;
import org.springframework.stereotype.Component;

@Component("messageView")
@ViewScoped
public class MessageView {
	private List<Message> messages;  
 
    @PostConstruct
    public void init() {
        createFirstTimeline();
    }
 
    private void createFirstTimeline() {
    	messages = new ArrayList<Message>();
    	messages.add(new Message("Dyrektor", "Zebranie", "11/03/2017"));
    	messages.add(new Message("Nauczyciel", "Obuwie", "12/03/2017"));
    	messages.add(new Message("Nauczyciel", "Wycieczka", "13/03/2017"));
    	messages.add(new Message("Nauczyciel", "Szczotka do wymiany", "14/03/2017"));
    }

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
    
}
