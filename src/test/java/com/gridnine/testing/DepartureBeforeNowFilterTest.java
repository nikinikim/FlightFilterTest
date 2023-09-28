package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartureBeforeNowFilterTest {

    @Test
    void testArrivalBeforeDepartureFilter() {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilter filter = new ArrivalBeforeDepartureFilter();
        List<Flight> filteredFlights = filter.filter(flights);
        assertEquals(5, filteredFlights.size());
    }
}