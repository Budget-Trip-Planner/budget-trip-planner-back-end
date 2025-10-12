package com.planner.app.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name= "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "last_name", length = 250)
    private String lastName;

    @Column(name = "first_name", length = 250)
    private String firstName;

    @Column(name = "username", length = 250, nullable = false,unique = true)
    private String username;

    @Column(name = "password", length = 250, nullable = false)
    private String password;

    @Column(name = "mail", length = 250, nullable = false,unique = true)
    private String mail;

    @Column(name = "phone_numb", length = 20)
    private String phoneNumber;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "pp", length = 250)
    private String pp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    public User() {}

    public User(String username, String password, String mail) {
        this.username = username;
        this.password = password;
        this.mail = mail;
    }

    public UUID getId() { return id; }

    public void setId(UUID id) { this.id = id; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getMail() { return mail; }

    public void setMail(String mail) { this.mail = mail; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public Date getBirthday() { return birthday; }

    public void setBirthday(Date birthday) { this.birthday = birthday; }

    public String getPp() { return pp; }

    public void setPp(String pp) { this.pp = pp; }

    public Location getLocation() { return location; }

    public void setLocation(Location location) { this.location = location; }

}
