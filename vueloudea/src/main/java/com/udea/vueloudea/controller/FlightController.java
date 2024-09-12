package com.udea.vueloudea.controller;

import com.udea.vueloudea.model.Flight;
import com.udea.vueloudea.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
@CrossOrigin(origins = "http://localhost:3000")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/search")
    public List<Flight> searchFlights(@RequestParam("startDate") String startDate,
                                      @RequestParam("endDate") String endDate,
                                      @RequestParam(value = "origin", required = false) String origin,
                                      @RequestParam(value = "destination", required = false) String destination,
                                      @RequestParam(value = "maxPrice", required = false) Double maxPrice,
                                      @RequestParam(value = "className", required = false) String className,
                                      @RequestParam(value = "equipment", required = false) Integer equipment,
                                      @RequestParam(value = "passengers", required = false) Integer passengers) {
        return flightService.findFlights(LocalDate.parse(startDate), LocalDate.parse(endDate), origin, destination, maxPrice, className, equipment, passengers);
    }
}
