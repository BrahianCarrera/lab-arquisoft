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

    public List<Flight> findFlights(LocalDate startDate, LocalDate endDate, String origin, String destination, Double maxPrice, String className, String equipment) {
        // Generate a key based on which parameters are not null
        String key = (origin != null ? "1" : "0") +
                (destination != null ? "1" : "0") +
                (maxPrice != null ? "1" : "0") +
                (className != null ? "1" : "0") +
                (equipment != null ? "1" : "0");

        switch (key) {
            case "11111": // All parameters are not null
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndClassNameContainingIgnoreCaseAndEquipmentContainingIgnoreCase(
                        startDate, endDate, origin, destination, maxPrice, className, equipment);
            case "11110": // All except equipment
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndClassNameContainingIgnoreCase(
                        startDate, endDate, origin, destination, maxPrice, className);
            case "11101": // All except className
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndEquipmentContainingIgnoreCase(
                        startDate, endDate, origin, destination, maxPrice, equipment);
            case "11100": // Origin, destination, maxPrice
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(
                        startDate, endDate, origin, destination, maxPrice);
            case "11011": // All except maxPrice
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndClassNameContainingIgnoreCaseAndEquipmentContainingIgnoreCase(
                        startDate, endDate, origin, destination, className, equipment);
            case "11010": // Origin, destination, className
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndClassNameContainingIgnoreCase(
                        startDate, endDate, origin, destination, className);
            case "11001": // Origin, destination, equipment
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndEquipmentContainingIgnoreCase(
                        startDate, endDate, origin, destination, equipment);
            case "11000": // Origin, destination
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCase(
                        startDate, endDate, origin, destination);
            case "10111": // All except destination
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqualAndClassNameContainingIgnoreCaseAndEquipmentContainingIgnoreCase(
                        startDate, endDate, origin, maxPrice, className, equipment);
            case "10110": // Origin, maxPrice, className
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqualAndClassNameContainingIgnoreCase(
                        startDate, endDate, origin, maxPrice, className);
            case "10101": // Origin, maxPrice, equipment
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqualAndEquipmentContainingIgnoreCase(
                        startDate, endDate, origin, maxPrice, equipment);
            case "10100": // Origin, maxPrice
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqual(
                        startDate, endDate, origin, maxPrice);
            case "10011": // Origin, className, equipment
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndClassNameContainingIgnoreCaseAndEquipmentContainingIgnoreCase(
                        startDate, endDate, origin, className, equipment);
            case "10010": // Origin, className
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndClassNameContainingIgnoreCase(
                        startDate, endDate, origin, className);
            case "10001": // Origin, equipment
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndEquipmentContainingIgnoreCase(
                        startDate, endDate, origin, equipment);
            case "10000": // Only origin
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCase(
                        startDate, endDate, origin);
            case "01111": // All except origin
                return flightRepository.findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndClassNameContainingIgnoreCaseAndEquipmentContainingIgnoreCase(
                        startDate, endDate, destination, maxPrice, className, equipment);
            case "01110": // Destination, maxPrice, className
                return flightRepository.findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndClassNameContainingIgnoreCase(
                        startDate, endDate, destination, maxPrice, className);
            case "01101": // Destination, maxPrice, equipment
                return flightRepository.findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndEquipmentContainingIgnoreCase(
                        startDate, endDate, destination, maxPrice, equipment);
            case "01100": // Destination, maxPrice
                return flightRepository.findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(
                        startDate, endDate, destination, maxPrice);
            case "01011": // Destination, className, equipment
                return flightRepository.findByDateBetweenAndDestinationContainingIgnoreCaseAndClassNameContainingIgnoreCaseAndEquipmentContainingIgnoreCase(
                        startDate, endDate, destination, className, equipment);
            case "01010": // Destination, className
                return flightRepository.findByDateBetweenAndDestinationContainingIgnoreCaseAndClassNameContainingIgnoreCase(
                        startDate, endDate, destination, className);
            case "01001": // Destination, equipment
                return flightRepository.findByDateBetweenAndDestinationContainingIgnoreCaseAndEquipmentContainingIgnoreCase(
                        startDate, endDate, destination, equipment);
            case "01000": // Only destination
                return flightRepository.findByDateBetweenAndDestinationContainingIgnoreCase(
                        startDate, endDate, destination);
            case "00111": // MaxPrice, className, equipment
                return flightRepository.findByDateBetweenAndPriceLessThanEqualAndClassNameContainingIgnoreCaseAndEquipmentContainingIgnoreCase(
                        startDate, endDate, maxPrice, className, equipment);
            case "00110": // MaxPrice, className
                return flightRepository.findByDateBetweenAndPriceLessThanEqualAndClassNameContainingIgnoreCase(
                        startDate, endDate, maxPrice, className);
            case "00101": // MaxPrice, equipment
                return flightRepository.findByDateBetweenAndPriceLessThanEqualAndEquipmentContainingIgnoreCase(
                        startDate, endDate, maxPrice, equipment);
            case "00100": // Only maxPrice
                return flightRepository.findByDateBetweenAndPriceLessThanEqual(
                        startDate, endDate, maxPrice);
            case "00011": // ClassName, equipment
                return flightRepository.findByDateBetweenAndClassNameContainingIgnoreCaseAndEquipmentContainingIgnoreCase(
                        startDate, endDate, className, equipment);
            case "00010": // Only className
                return flightRepository.findByDateBetweenAndClassNameContainingIgnoreCase(
                        startDate, endDate, className);
            case "00001": // Only equipment
                return flightRepository.findByDateBetweenAndEquipmentContainingIgnoreCase(
                        startDate, endDate, equipment);
            case "00000": // No parameters (except dates)
            default:
                return flightRepository.findByDateBetween(startDate, endDate);
        }
    }
}
