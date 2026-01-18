package com.FlightAggregator;

public class FlightData {
    private String src;
    private String dest;

    private double cost;

    public FlightData(String src, String dest, double cost) {
        this.src = src;
        this.dest = dest;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "FlightData{" +
                "src='" + src + '\'' +
                ", dest='" + dest + '\'' +
                ", cost=" + cost +
                '}';
    }
}
