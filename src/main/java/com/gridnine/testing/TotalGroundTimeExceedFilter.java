package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TotalGroundTimeExceedFilter implements FlightFilter{
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> {
                    List<Segment> segments = flight.getSegments();
                    for (int i = 0; i < segments.size() - 1; i++) {
                        LocalDateTime currentArrival = segments.get(i).getArrivalDate();
                        LocalDateTime nextDeparture = segments.get(i + 1).getDepartureDate();
                        if (currentArrival.plusHours(2).isBefore(nextDeparture)) {
                            return true;
                        }
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }
}
