package com.scw.kindergarten.view;

public class Message {
	private String from;
	private String topic;
	private String date;
	
	
	public Message() {
		super();
	}
	public Message(String from, String topic, String date) {
		super();
		this.from = from;
		this.topic = topic;
		this.date = date;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
