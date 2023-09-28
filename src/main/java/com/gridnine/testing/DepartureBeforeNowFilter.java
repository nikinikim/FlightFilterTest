package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DepartureBeforeNowFilter implements FlightFilter{

    @Override
    public List<Flight> filter(List<Flight> flights) {
        LocalDateTime currentTime = LocalDateTime.now();
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate().isAfter(currentTime)))
                .collect(Collectors.toList());
    }
}
