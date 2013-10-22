package com.pk;

public class Parkinglot {


    private final int max;
    private int carport;

    private boolean isFull;

    public Parkinglot(int carport) {
        this.carport = carport;
        this.max = carport;
    }

    public ParkingTicket parking(Car car) {
            this.carport -= 1;
            return new ParkingTicket(car);
    }


    public boolean isFull() {
        return (max-this.carport) == max;
    }

    public Car fetchCar(ParkingTicket ticket) {
        return ticket.getCar();

    }

    public double getUsage() {
        return (double) (max - carport) / max;
    }

}
