package com.pk;

public class Parkinglog {


    private int carport;
    private boolean isFull;

    public Parkinglog(int carport) {
        this.carport = carport;
    }

    public ParkingTicket parking(Car car) {
        this.carport -=1;
        return new ParkingTicket(car);
    }

    public boolean isFull() {
        if (this.carport == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Car fetchCar(ParkingTicket ticket) {
        return ticket.getCar();

    }
}
