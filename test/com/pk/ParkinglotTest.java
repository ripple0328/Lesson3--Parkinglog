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
public class ParkinglotTest {
    Car car;

    Parkinglot parkinglot;
    ParkingTicket ticket;

    @Before
    public void setUp() throws Exception {
        parkinglot = new Parkinglot(3);

    }

    @Test
    public void should_the_parking_log_full_when_all_position_been_occupied() {

        parkinglot.parking(car);
        parkinglot.parking(car);
        parkinglot.parking(car);
        assertThat(parkinglot.isFull(), is(true));
    }

    @Test
    public void should_not_full_when_have_not_parking_full() throws Exception {
        parkinglot.parking(car);
        assertThat(parkinglot.isFull(), is(false));
    }

    @Test
    public void should_return_ticket_when_parking_car() {
        ticket = parkinglot.parking(car);
        boolean result = ticket instanceof ParkingTicket;

        assertThat(result, is(true));
    }

    @Test
    public void test_should_return_car_when_show_a_tickets() throws Exception {
        ticket = parkinglot.parking(car);
        Car fetched_car = parkinglot.fetchCar(ticket);
        assertThat(car, is(fetched_car));

    }

    @Test
    public void should_return_correct_usage() {
        parkinglot.parking(car);
        assertThat(parkinglot.getUsage(), is(1d/3d));

    }
}
