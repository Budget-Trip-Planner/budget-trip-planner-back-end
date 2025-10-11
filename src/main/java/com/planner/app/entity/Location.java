package com.planner.app.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name= "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "city", length = 150, nullable = false)
    private String city;

    @Column(name = "country", length = 100, nullable = false)
    private String country;

    public Location() {}

    public Location(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public UUID getId() { return id; }

    public void setId(UUID id) { this.id = id; }

}
