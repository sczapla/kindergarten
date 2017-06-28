package com.scw.kindergarten.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.scw.kindergarten.view.utils.Utils;

@Component("messageView")
@Scope("view")
public class MessageView implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Message> messages;
	private List<Message> selectedMsg;
	private List<Message> filteredValue;
	private Integer id;

	@PostConstruct
	public void init() {
		createFirstTimeline();
	}

	private void createFirstTimeline() {
		messages = new ArrayList<Message>();
		messages.add(new Message(1, "Dyrektor", "Zebranie", "11/03/2017", "przykladowa tresc"));
		messages.add(new Message(2, "Nauczyciel", "Obuwie", "12/03/2017", "przykladowa tresc2"));
		messages.add(new Message(3, "Nauczyciel", "Wycieczka", "13/03/2017", "przykladowa tresc3"));
		messages.add(new Message(4, "Nauczyciel", "Szczotka do wymiany", "14/03/2017", "przykladowa tresc4"));
		messages.add(new Message(5, "Nauczyciel", "Szczotka do wymiany", "14/03/2017", "przykladowa tresc4"));
		messages.add(new Message(6, "Nauczyciel", "Szczotka do wymiany", "14/03/2017", "przykladowa tresc4"));
	}

	public void send() {
		Utils.addDetailMessage("Wiadomość wysłana", FacesMessage.SEVERITY_INFO);
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public void findMsgById(Integer id) {

	}

	public List<Message> getSelectedMsg() {
		return selectedMsg;
	}

	public void setSelectedMsg(List<Message> selectedMsg) {
		this.selectedMsg = selectedMsg;
	}

	public List<Message> getFilteredValue() {
		return filteredValue;
	}

	public void setFilteredValue(List<Message> filteredValue) {
		this.filteredValue = filteredValue;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
