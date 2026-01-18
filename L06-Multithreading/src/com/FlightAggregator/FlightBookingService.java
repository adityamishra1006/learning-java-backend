package com.FlightAggregator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class FlightBookingService {

    private ExecutorService executorService = Executors.newFixedThreadPool(4);

    public List<FlightData> getAllFlightsData(String src, String dest, Date date) {
        FlightSearchInterface airIndiaService = new AirIndiaFlightSearchService();
        FlightSearchInterface indigoService = new IndigoFlightSearchService();

//        Callable<List<FlightData>> callableAirIndia = new Callable<List<FlightData>>() {
//            @Override
//            public List<FlightData> call() throws Exception {
//                return airIndiaService.getFlights(src, dest, date);
//            }
//        };


        Callable<List<FlightData>> callableAirIndia = () -> airIndiaService.getFlights(src, dest, date);
        Future<List<FlightData>> listFutureAirIndia = executorService.submit(callableAirIndia);

        Callable<List<FlightData>> callableIndigo = () -> indigoService.getFlights(src, dest, date);
        Future<List<FlightData>> listFutureIndigo = executorService.submit(callableIndigo);


        List<FlightData> finalResult = new ArrayList<>();
        try {
            finalResult.addAll((listFutureAirIndia.get()));
            finalResult.addAll(listFutureIndigo.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        return finalResult;
    }
}
