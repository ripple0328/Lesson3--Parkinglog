package com.pk;

/**
 * Created with IntelliJ IDEA.
 * User: qingbo
 * Date: 13-10-15
 * Time: PM6:01
 * To change this template use File | Settings | File Templates.
 */
public class ParkingTicket {
    private Car car;

    public ParkingTicket(Car car) {

        this.car = car;
    }

    public Car getCar() {
        return car;
    }
}
