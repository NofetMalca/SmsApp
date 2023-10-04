package com.example.springStart.BaseORM.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="messages")
public class Message {
    @Id
    @Column(name="message_id")
    @JsonProperty
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="sender_id")
    @JsonProperty
    private String senderId;

    @Column(name="reciever_id")
    @JsonProperty
    private String recieverId;

    @Column(name="message_content")
    @JsonProperty
    private String messageContent;

    @Column(name="sending_time")
    @JsonProperty
    private Date sendingTime;

    public Message() {}

    public Message(String senderId, String recieverId, String messageContent, Date sendingTime) {
        this.senderId = senderId;
        this.recieverId = recieverId;
        this.messageContent = messageContent;
        this.sendingTime = sendingTime;
    }
    public String senderId() {
        return this.senderId;
    }

    public String recieverId() {
        return this.recieverId;
    }

    public String messageContent() {
        return this.messageContent;
    }

    public Date sendingTime() {
        return this.sendingTime;
    }

}
