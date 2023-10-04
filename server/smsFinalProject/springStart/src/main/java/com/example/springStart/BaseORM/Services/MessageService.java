package com.example.springStart.BaseORM.Services;

import com.example.springStart.BaseORM.Models.Message;
import com.example.springStart.BaseORM.Models.User;
import com.example.springStart.BaseORM.Repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return this.messageRepository.findAll();
    }

    public List<Message> getAllMassagesOfRoom(String senderId, String recieverId) {
        return this.messageRepository.findBySenderIdAndRecieverIdOrSenderIdAndRecieverId(senderId, recieverId, recieverId, senderId);
    }

    public Set<Message> getRoomsById(String senderId) {
        List usedId = new ArrayList();
        List<Message> room = this.messageRepository.findBySenderIdEquals(senderId);
        List<Message> distinctRoom = new ArrayList<Message>();
        for (Message currMessage : room) {
            if (!usedId.contains(currMessage.recieverId())) {
                distinctRoom.add(currMessage);
                usedId.add(currMessage.recieverId());
            }
        }
        Set<Message> roomSet = new HashSet<Message>();
        roomSet.addAll(distinctRoom);
        return roomSet;
    }

    public Message addMessageToDb(Message message) {
        return this.messageRepository.save(message);
//        return this.messageRepository.save(new Message(message.senderId(), message.recieverId(), message.messageContent(), message.sendingTime()));
    }


}
