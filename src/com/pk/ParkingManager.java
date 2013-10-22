package com.pk;

import java.util.ArrayList;
import java.util.List;


public class ParkingManager {
    public List<Parkinglot> parkinglots;

    public ParkingManager() {
        ArrayList<Parkinglot> parkinglots = new ArrayList<Parkinglot>();
        this.parkinglots = parkinglots;
    }

    public ParkingTicket park(Car car) {
        Parkinglot lstUsageLot = parkinglots.get(0);
        for(Parkinglot  p : parkinglots )
        {
            if (p.isFull()) continue;
            if(p.getUsage() < lstUsageLot.getUsage())
            { lstUsageLot = p;}

        }
        return  lstUsageLot.parking(car);
    }

    public Car fetchCar(ParkingTicket ticket) {
        return  parkinglots.get(0).fetchCar(ticket);
    }
}
