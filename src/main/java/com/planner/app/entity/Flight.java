package com.planner.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Table(name = "flights", uniqueConstraints = @UniqueConstraint(columnNames = {"voyage_id", "direction"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voyage_id", nullable = false)
    private Voyage voyage;

    @Column(nullable = false, length = 10)
    private String direction;

    @Column(nullable = false, length = 100)
    private String airline;

    @Column(name = "flight_number", nullable = false, length = 20)
    private String flightNumber;

    @Column(name = "departure_airport_code", nullable = false, length = 10)
    private String departureAirportCode;

    @Column(name = "departure_airport_name", length = 200)
    private String departureAirportName;

    @Column(name = "arrival_airport_code", nullable = false, length = 10)
    private String arrivalAirportCode;

    @Column(name = "arrival_airport_name", length = 200)
    private String arrivalAirportName;

    @Column(name = "departure_datetime", nullable = false)
    private LocalDateTime departureDateTime;

    @Column(name = "arrival_datetime", nullable = false)
    private LocalDateTime arrivalDateTime;

    @Column(length = 20)
    private String duration;

    @JsonProperty("class")
    @Column(name = "class", length = 50)
    private String flightClass = "economy";

    @Column(nullable = false)
    private Integer stops = 0;

    @Column(name = "total_price", precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @Column(nullable = false, length = 3)
    private String currency = "EUR";

    @Column(nullable = false)
    private Integer passengers = 1;

    @Column(name = "booking_class", nullable = false, length = 50)
    private String bookingClass = "economy";

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt = OffsetDateTime.now();

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            createdAt = OffsetDateTime.now();
        }
    }
}
