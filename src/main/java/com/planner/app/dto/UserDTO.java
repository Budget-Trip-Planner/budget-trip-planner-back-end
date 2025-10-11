package com.planner.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String lastName;
    private String firstName;
    private String username;
    private String mail;
    private String phoneNumber;
    private Date birthday;
    private String pp;

    public UserDTO(String lastName, String firstName, String username, String mail, String phoneNumber, Date birthday, String pp) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.username = username;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.pp = pp;
    }
}
