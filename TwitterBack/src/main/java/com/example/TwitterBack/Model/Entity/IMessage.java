package com.example.TwitterBack.Model.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class IMessage {
@Id
@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	private String contenu;
	
	@ManyToOne
	@JoinColumn(name="sender_id")
	private IUser sender;
	
	@ManyToOne
	@JoinColumn(name="receiver_id")
	private IUser receiver;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public IUser getSender() {
		return sender;
	}
	public void setSender(IUser sender) {
		this.sender = sender;
	}
	public IUser getReceiver() {
		return receiver;
	}
	public void setReceiver(IUser receiver) {
		this.receiver = receiver;
	}
	
	
	
	
	
	
}
