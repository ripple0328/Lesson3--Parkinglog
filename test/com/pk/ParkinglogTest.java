package com.pk;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: qingbo
 * Date: 13-10-15
 * Time: PM5:53
 * To change this template use File | Settings | File Templates.
 */
public class ParkinglogTest {
    Car car;

    Parkinglog parkinglog;
    ParkingTicket ticket;

    @Before
    public void setUp() throws Exception {
        parkinglog = new Parkinglog(3);

    }

    @Test
    public void should_the_parking_log_full_when_all_position_been_occupied() {

        parkinglog.parking(car);
        parkinglog.parking(car);
        parkinglog.parking(car);
        assertThat(parkinglog.isFull(), is(true));
    }

    @Test
    public void should_not_full_when_have_not_parking_full() throws Exception {
        parkinglog.parking(car);
        assertThat(parkinglog.isFull(), is(false));
    }

    @Test
    public void should_return_ticket_when_parking_car() {
        ticket = parkinglog.parking(car);
        boolean result = ticket instanceof ParkingTicket;

        assertThat(result, is(true));
    }

    @Test
    public void test_should_return_car_when_show_a_tickets() throws Exception {
        ticket = parkinglog.parking(car);
        Car fetched_car = parkinglog.fetchCar(ticket);
        assertThat(car, is(fetched_car));

    }
}
