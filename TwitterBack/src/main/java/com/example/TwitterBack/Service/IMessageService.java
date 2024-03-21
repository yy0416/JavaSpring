package com.example.TwitterBack.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TwitterBack.Model.DTO.IMessageDTO;
import com.example.TwitterBack.Model.Entity.IMessage;
import com.example.TwitterBack.Model.Entity.IUser;
import com.example.TwitterBack.Model.Repository.IMessageRepository;

@Service
public class IMessageService {
	@Autowired
	private IUserService userService;
	private IMessageRepository IMessageRp;
	

	//Envoyer un message d'un utilisateur à un autre
	

	public IMessage envoyerMessage(String contenu, IUser sender,IUser receiver) {
		if(sender == null || receiver == null) {
			throw new IllegalArgumentException("Sender or receiver can't be empty");
		}
		
		IMessage newMessage = new IMessage();
		newMessage.setContenu(contenu);
		newMessage.setReceiver(receiver);
		newMessage.setSender(sender);
		return this.IMessageRp.save(newMessage);
	}
	
	//Save des messages
	
	public IMessageDTO addMessage(IMessageDTO imsgdto) {
		var resu = this.IMessageRp.save(this.convertToMessage(imsgdto));
		return this.convertToDTO(resu);
	}
	
	//Récupérer tous les messages envoyés et reçus par un utilisateur
	public IMessageDTO findMessageByName(String username){
		var res = this.IMessageRp.findMessageByUsername(username).get();
		return this.convertToDTO(res);
}
	
	public List<IMessageDTO> getAllMessage(){
		return this.IMessageRp.findAll().stream().map((val)->this.convertToDTO(val)).toList();
	}

	

	//Récupérer les détails d'un message spécifique par son ID	
	public IMessageDTO findMessageById(Long id){
		var resultat = this.IMessageRp.findById(id).get();
		return this.convertToDTO(resultat);
	}
	
	//Mettre à jour le contenu d'un message.
	public IMessageDTO updateMessage(IMessageDTO contenu, Long id) {
		IMessageDTO msgdto = this.convertToDTO(IMessageRp.findById(id).get());
		msgdto.setContenu(contenu.getContenu());
		msgdto.setReceiverId(contenu.getReceiverId());
		msgdto.setSenderId(contenu.getSenderId());
		return this.addMessage(msgdto);
	}
	
	//Supprimer un message.
	public void deleteMessageById(Long id) {
		this.IMessageRp.deleteById(id);
	}
	
	public IMessageDTO convertToDTO(IMessage msg) {
		IMessageDTO imsgdto = new IMessageDTO();
		imsgdto.setContenu(msg.getContenu());
		imsgdto.setId(msg.getId());
		imsgdto.setReceiverId(msg.getReceiver().getId());
		imsgdto.setSenderId(msg.getSender().getId());
		return imsgdto;
		
	}
	
	public IMessage convertToMessage(IMessageDTO msgdto) {
		IMessage imsg = new IMessage();
		imsg.setContenu(msgdto.getContenu());
		imsg.setId(msgdto.getId());
		imsg.setSender(userService.getInfoById(msgdto.getSenderId()));
		imsg.setReceiver(userService.getInfoById(msgdto.getReceiverId()));
		return imsg;
	}
	
	
}
