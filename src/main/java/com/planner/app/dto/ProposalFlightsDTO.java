package com.planner.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProposalFlightsDTO {
    private GeminiFlightInfoDTO outbound;

    @JsonProperty("return")
    private GeminiFlightInfoDTO returnFlight;

    private BigDecimal totalPrice;
    private String currency;
    private Integer passengers;
    private String bookingClass;
}
