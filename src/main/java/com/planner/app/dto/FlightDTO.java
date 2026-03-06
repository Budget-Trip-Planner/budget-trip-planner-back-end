package com.planner.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightDTO {

    private Integer id;
    private Integer voyageId;
    private String direction;
    private String airline;
    private String flightNumber;
    private String departureAirportCode;
    private String departureAirportName;
    private String arrivalAirportCode;
    private String arrivalAirportName;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private String duration;

    @JsonProperty("class")
    private String flightClass;

    private Integer stops;
    private BigDecimal totalPrice;
    private String currency;
    private Integer passengers;
    private String bookingClass;
    private OffsetDateTime createdAt;
}