package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TotalGroundTimeExceedFilterTest {

    @Test
    void testTotalGroundTimeExceedsTwoHoursFilter() {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilter filter = new TotalGroundTimeExceedFilter();
        List<Flight> filteredFlights = filter.filter(flights);
        assertEquals(1, filteredFlights.size());
    }
}