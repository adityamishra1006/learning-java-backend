package com.FlightAggregator;

import java.util.Date;
import java.util.List;

public interface FlightSearchInterface {
    List<FlightData> getFlights(String src, String dest, Date date);

}
