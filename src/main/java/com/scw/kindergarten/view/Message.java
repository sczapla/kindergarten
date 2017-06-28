package com.scw.kindergarten.view;

public class Message {
	private Integer id;
	private String from;
	private String topic;
	private String date;
	private String content;

	public Message() {
		super();
	}

	public Message(Integer id, String from, String topic, String date, String content) {
		super();
		this.id = id;
		this.from = from;
		this.topic = topic;
		this.date = date;
		this.content = content;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
