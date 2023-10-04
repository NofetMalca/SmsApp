package com.example.springStart.BaseORM.Repositories;

import com.example.springStart.BaseORM.Models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
//    List<Message> findBySenderIdAndRecieverId(String senderId, String recieverId);
List<Message> findBySenderIdAndRecieverIdOrSenderIdAndRecieverId(String senderId, String recieverId, String recieverId1, String senderId2);
    List<Message> findBySenderIdEquals(String senderId);

}
