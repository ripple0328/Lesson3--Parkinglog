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
        car = new Car();
    }

    @Test
    public void should_have_two_parkinglog() throws Exception {

        assertThat(parkingManager.getParkinglogs().size(), is(2));

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
    public void should_park_in_second_log_when_first_log_is_full() throws Exception {
//          Parkinglog log = mock(Parkinglog.class);
    }
}
