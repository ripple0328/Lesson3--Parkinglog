package com.pk;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: qingbo
 * Date: 13-10-15
 * Time: PM6:24
 * To change this template use File | Settings | File Templates.
 */
public class ParkingManagerTest {
    ParkingManager parkingManager;
    Car car;


    @Before
    public void setUp() throws Exception {
        parkingManager = new ParkingManager();
        parkingManager.parkinglots.add(new Parkinglot(2));
        parkingManager.parkinglots.add(new Parkinglot(3));
        car = new Car();
    }


    @Test
    public void should_ParkingManger_park_car_and_return_ticket() throws Exception {
        ParkingTicket ticket = parkingManager.park(car);
        assertThat(ticket instanceof ParkingTicket, is(true));
    }

    @Test
    public void should_unpark_car() throws Exception {
        ParkingTicket ticket = parkingManager.park(car);
        Car fetchedCar = parkingManager.fetchCar(ticket);
        assertThat(fetchedCar, is(car));
    }

    @Test
    public void should_park_in_least_usage_lot() throws Exception {
        ParkingTicket ticket1 = parkingManager.park(car);
        assertThat(parkingManager.parkinglots.get(0).getUsage(),is(1d/2d));
        assertThat(parkingManager.parkinglots.get(1).getUsage(),is(0d/3d));
        ParkingTicket ticket2 = parkingManager.park(car);
        assertThat(parkingManager.parkinglots.get(0).getUsage(),is(1d/2d));
        assertThat(parkingManager.parkinglots.get(1).getUsage(),is(1d/3d));
        ParkingTicket ticket3 = parkingManager.park(car);
        assertThat(parkingManager.parkinglots.get(0).getUsage(),is(1d/2d));
        assertThat(parkingManager.parkinglots.get(1).getUsage(),is(2d/3d));
    }
}
