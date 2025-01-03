package com.example.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table
@Entity
@NoArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;

    private String email;

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

//    private String password;
}
