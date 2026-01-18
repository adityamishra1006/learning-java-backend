package com.FlightAggregator;

import java.util.Date;
import java.util.List;

public class FlightBokingDemo {
    public static void main(String[] args) {
        FlightBookingService flightBookingService = new FlightBookingService();
        List<FlightData> allData = flightBookingService.getAllFlightsData("DEL", "IXR", new Date());
        System.out.println(allData);
    }
}
