package com.planner.app.service;

import com.planner.app.dao.FlightRepository;
import com.planner.app.dao.VoyageRepository;
import com.planner.app.dto.FlightDTO;
import com.planner.app.entity.Flight;
import com.planner.app.entity.Voyage;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;
    private final VoyageRepository voyageRepository;

    public List<Flight> getFlightsByVoyageId(Integer voyageId) {
        return flightRepository.findByVoyageId(voyageId);
    }

    public Flight getFlightById(Integer id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found with id: " + id));
    }

    public Flight addFlightToVoyage(Integer voyageId, FlightDTO dto) {
        Voyage voyage = voyageRepository.findById(voyageId)
                .orElseThrow(() -> new RuntimeException("Voyage not found with id: " + voyageId));

        if (flightRepository.existsByVoyageIdAndDirection(voyageId, dto.getDirection())) {
            throw new IllegalStateException(
                    "A " + dto.getDirection() + " flight already exists for voyage " + voyageId);
        }

        Flight flight = new Flight();
        flight.setVoyage(voyage);
        flight.setDirection(dto.getDirection());
        flight.setAirline(dto.getAirline());
        flight.setFlightNumber(dto.getFlightNumber());
        flight.setDepartureAirportCode(dto.getDepartureAirportCode());
        flight.setDepartureAirportName(dto.getDepartureAirportName());
        flight.setArrivalAirportCode(dto.getArrivalAirportCode());
        flight.setArrivalAirportName(dto.getArrivalAirportName());
        flight.setDepartureDateTime(dto.getDepartureDateTime());
        flight.setArrivalDateTime(dto.getArrivalDateTime());
        flight.setDuration(dto.getDuration());
        if (dto.getFlightClass() != null) flight.setFlightClass(dto.getFlightClass());
        if (dto.getStops() != null) flight.setStops(dto.getStops());
        flight.setTotalPrice(dto.getTotalPrice());
        if (dto.getCurrency() != null) flight.setCurrency(dto.getCurrency());
        if (dto.getPassengers() != null) flight.setPassengers(dto.getPassengers());
        if (dto.getBookingClass() != null) flight.setBookingClass(dto.getBookingClass());

        return flightRepository.save(flight);
    }

    public void deleteFlight(Integer id) {
        if (!flightRepository.existsById(id)) {
            throw new RuntimeException("Flight not found with id: " + id);
        }
        flightRepository.deleteById(id);
    }
}