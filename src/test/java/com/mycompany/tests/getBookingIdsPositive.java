package com.mycompany.tests;

import com.mycompany.utils.client.BookingClient;

import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;


public class getBookingIdsPositive {
    BookingClient bookingClient = new BookingClient();

    @Test
    public void getBookingIdsReturn200OK() throws IOException {
        bookingClient.getBookingIds()
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void getBookingIdsStatusLineOk() throws IOException{
        bookingClient.getBookingIds()
                .then()
                .statusLine(containsString("OK"));
    }

    @Test
    public void getBookingIdsVerifyContentType() throws IOException{
        bookingClient.getBookingIds()
                .then()
                .contentType("application/json; charset=utf-8");
    }


}
