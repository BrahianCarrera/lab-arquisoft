package com.udea.vueloudea.service;

import com.udea.vueloudea.model.Flight;
import com.udea.vueloudea.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> findFlights(LocalDate startDate, LocalDate endDate, String origin, String destination, Double maxPrice, String className, Integer equipment, Integer passengers) {
        // Generar una clave basada en los parámetros que no son nulos
        String key = (origin != null ? "1" : "0") +
                (destination != null ? "1" : "0") +
                (maxPrice != null ? "1" : "0") +
                (className != null ? "1" : "0") +
                (equipment != null ? "1" : "0") +
                (passengers != null ? "1" : "0");

        return switch (key) {
            case "111000" -> // origin, destination, maxPrice no son nulos
                    flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(
                            startDate, endDate, origin, destination, maxPrice);
            case "110000" -> // origin, destination no son nulos, maxPrice es nulo
                    flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCase(
                            startDate, endDate, origin, destination);
            case "101000" -> // origin y maxPrice no son nulos, destination es nulo
                    flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqual(
                            startDate, endDate, origin, maxPrice);
            case "011000" -> // destination y maxPrice no son nulos, origin es nulo
                    flightRepository.findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(
                            startDate, endDate, destination, maxPrice);
            case "100000" -> // solo origin no es nulo
                    flightRepository.findByDateBetweenAndOriginContainingIgnoreCase(
                            startDate, endDate, origin);
            case "010000" -> // solo destination no es nulo
                    flightRepository.findByDateBetweenAndDestinationContainingIgnoreCase(
                            startDate, endDate, destination);
            case "001000" -> // solo maxPrice no es nulo
                    flightRepository.findByDateBetweenAndPriceLessThanEqual(
                            startDate, endDate, maxPrice);
            case "000100" -> // solo className no es nulo
                    flightRepository.findByDateBetweenAndClassName(
                            startDate, endDate, className);
            case "000010" -> // solo equipment no es nulo
                    flightRepository.findByDateBetweenAndEquipmentLessThanEqual(
                            startDate, endDate, equipment);
            case "000001" -> // solo passengers no es nulo
                    flightRepository.findByDateBetweenAndPassengersLessThanEqual(
                            startDate, endDate, passengers);
            case "000000" -> // todos son nulos
                    flightRepository.findByDateBetween(startDate, endDate);
            default -> flightRepository.findByDateBetween(startDate, endDate);
        };
    }
}
