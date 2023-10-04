package com.example.springStart.BaseORM.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @Column(name="user_name")
    @JsonProperty
    private String userName;

    @OneToOne
    @JoinColumn(name="user_id")
    @JsonIgnoreProperties("userId")
    @JsonProperty
    public Employee userId;

    @Column(name="user_password")
    @JsonProperty
    private String userPassword;

    public User() {}
    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }
    public String userName() {
        return this.userName;
    }
    public String userPassword() {
        return this.userPassword;
    }


}

