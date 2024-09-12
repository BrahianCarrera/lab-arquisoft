package com.udea.vueloudea.repository;

import com.udea.vueloudea.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(LocalDate startDate, LocalDate endDate, String origin, String destination, Double maxPrice);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCase(LocalDate startDate, LocalDate endDate, String origin, String destination);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqual(LocalDate startDate, LocalDate endDate, String origin, Double maxPrice);

    List<Flight> findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(LocalDate startDate, LocalDate endDate, String destination, Double maxPrice);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCase(LocalDate startDate, LocalDate endDate, String origin);

    List<Flight> findByDateBetweenAndDestinationContainingIgnoreCase(LocalDate startDate, LocalDate endDate, String destination);

    List<Flight> findByDateBetweenAndPriceLessThanEqual(LocalDate startDate, LocalDate endDate, Double maxPrice);

    List<Flight> findByDateBetweenAndClassName(LocalDate startDate, LocalDate endDate, String className);

    List<Flight> findByDateBetweenAndEquipmentLessThanEqual(LocalDate startDate, LocalDate endDate, Integer equipment);

    List<Flight> findByDateBetweenAndPassengersLessThanEqual(LocalDate startDate, LocalDate endDate, Integer passengers);

    List<Flight> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
