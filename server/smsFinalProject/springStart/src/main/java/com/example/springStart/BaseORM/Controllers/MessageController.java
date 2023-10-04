package com.example.springStart.BaseORM.Controllers;

import com.example.springStart.BaseORM.Models.Message;
import com.example.springStart.BaseORM.Models.User;
import com.example.springStart.BaseORM.Services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    // Example: http://localhost:9000/messages
    @CrossOrigin
    @GetMapping("")
    public List<Message> getAll() {
        return this.messageService.getAll();
    }

    // Example: http://localhost:9000/messages/room/000280/000290
    @CrossOrigin
    @GetMapping("/room/{senderId}/{recieverId}")
    public List<Message> getAllMassagesOfRoom(@PathVariable String senderId, @PathVariable String recieverId) {
        return this.messageService.getAllMassagesOfRoom(senderId, recieverId);
    }

    // Example: http://localhost:9000/messages/room/id/000310
    @CrossOrigin
    @GetMapping("/room/id/{senderId}")
    public Set<Message> getRoomsById(@PathVariable String senderId) {
        return this.messageService.getRoomsById(senderId);
    }

    //Example: http://localhost:9000/messages/add/
    @CrossOrigin
    @PostMapping("/add")
    public Message addMessageToDb(@RequestBody Message message) {
        return this.messageService.addMessageToDb(message);
    }

}
