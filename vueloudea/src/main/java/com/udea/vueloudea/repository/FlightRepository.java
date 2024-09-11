package com.udea.vueloudea.repository;

import com.udea.vueloudea.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String origin, String destination);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqual(
            LocalDate startDate, LocalDate endDate, String origin, double maxPrice);

    List<Flight> findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(
            LocalDate startDate, LocalDate endDate, String destination, double maxPrice);

    List<Flight> findByDateBetween(LocalDate startDate, LocalDate endDate);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCase(LocalDate startDate, LocalDate endDate, String origin);

    List<Flight> findByDateBetweenAndDestinationContainingIgnoreCase(LocalDate startDate, LocalDate endDate, String destination);

    List<Flight> findByDateBetweenAndPriceLessThanEqual(LocalDate startDate, LocalDate endDate, double maxPrice);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(
            LocalDate startDate, LocalDate endDate, String origin, String destination, double maxPrice);

    // Existing methods for className and equipment
    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndClassNameContainingIgnoreCaseAndEquipmentContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String origin, String destination, double maxPrice, String className, String equipment);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndClassNameContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String origin, String destination, double maxPrice, String className);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndEquipmentContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String origin, String destination, double maxPrice, String equipment);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndClassNameContainingIgnoreCaseAndEquipmentContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String origin, String className, String equipment);

    List<Flight> findByDateBetweenAndDestinationContainingIgnoreCaseAndClassNameContainingIgnoreCaseAndEquipmentContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String destination, String className, String equipment);

    List<Flight> findByDateBetweenAndClassNameContainingIgnoreCaseAndEquipmentContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String className, String equipment);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndClassNameContainingIgnoreCaseAndEquipmentContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String origin, String destination, String className, String equipment);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqualAndClassNameContainingIgnoreCaseAndEquipmentContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String origin, Double maxPrice, String className, String equipment);

    List<Flight> findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndClassNameContainingIgnoreCaseAndEquipmentContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String destination, Double maxPrice, String className, String equipment);

    // New methods to cover all combinations
    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndClassNameContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String origin, String destination, String className);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndEquipmentContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String origin, String destination, String equipment);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqualAndClassNameContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String origin, Double maxPrice, String className);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqualAndEquipmentContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String origin, Double maxPrice, String equipment);

    List<Flight> findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndClassNameContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String destination, Double maxPrice, String className);

    List<Flight> findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndEquipmentContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String destination, Double maxPrice, String equipment);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndClassNameContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String origin, String className);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndEquipmentContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String origin, String equipment);

    List<Flight> findByDateBetweenAndDestinationContainingIgnoreCaseAndClassNameContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String destination, String className);

    List<Flight> findByDateBetweenAndDestinationContainingIgnoreCaseAndEquipmentContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String destination, String equipment);

    List<Flight> findByDateBetweenAndPriceLessThanEqualAndClassNameContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, Double maxPrice, String className);

    List<Flight> findByDateBetweenAndPriceLessThanEqualAndEquipmentContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, Double maxPrice, String equipment);

    List<Flight> findByDateBetweenAndClassNameContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String className);

    List<Flight> findByDateBetweenAndEquipmentContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String equipment);

    List<Flight> findByDateBetweenAndPriceLessThanEqualAndClassNameContainingIgnoreCaseAndEquipmentContainingIgnoreCase(LocalDate startDate, LocalDate endDate, Double maxPrice, String className, String equipment);
}