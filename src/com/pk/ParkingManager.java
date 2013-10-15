package com.pk;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: qingbo
 * Date: 13-10-15
 * Time: PM6:24
 * To change this template use File | Settings | File Templates.
 */
public class ParkingManager {
    private List<Parkinglog> parkinglogs;

    public ParkingManager() {
        ArrayList<Parkinglog> parkinglogs = new ArrayList<Parkinglog>();
        Parkinglog parkinglog = new Parkinglog(10);
        Parkinglog parkinglog2 = new Parkinglog(10);

        parkinglogs.add(parkinglog);
        parkinglogs.add(parkinglog2);

        this.parkinglogs = parkinglogs;
    }

    public List<Parkinglog> getParkinglogs() {

        return parkinglogs;
    }

    public ParkingTicket park(Car car) {
        return  parkinglogs.get(0).parking(car);
    }

    public Car fetchCar(ParkingTicket ticket) {
        return  parkinglogs.get(0).fetchCar(ticket);
    }
}
