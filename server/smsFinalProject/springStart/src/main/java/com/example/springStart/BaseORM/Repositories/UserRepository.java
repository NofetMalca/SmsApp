package com.example.springStart.BaseORM.Repositories;

import com.example.springStart.BaseORM.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUserNameAndUserPassword(String userName, String userPassword);
}
