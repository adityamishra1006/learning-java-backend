package com.FlightAggregator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IndigoFlightSearchService implements FlightSearchInterface{


    @Override
    public List<FlightData> getFlights(String src, String dest, Date date) {
        /*
         * This method would typically connect to the Indigo flight database or API
         */
        List<FlightData> flightData = new ArrayList<>();
        flightData.add(new FlightData("DEL", "IXR", 6000.00));
        flightData.add(new FlightData("DEL", "IXR", 7500.00));
        flightData.add(new FlightData("DEL", "IXR", 9000.00));

        return flightData;
    }
}
