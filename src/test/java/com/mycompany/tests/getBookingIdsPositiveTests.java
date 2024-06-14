package com.mycompany.tests;

import com.mycompany.utils.client.BookingClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.containsString;

public class getBookingIdsPositiveTests {
    BookingClient bookingClient = new BookingClient();

    @DisplayName("Check status code 200 getBookingIdsPositive")
    @Description("Check status code 200 getBookingIdsPositive")
    @Test
    public void getBookingIdsReturn200OK() throws IOException {
        bookingClient.getBookingIds()
                .then()
                .assertThat()
                .statusCode(200);
    }

    @DisplayName("Check status Line OK getBookingIdsPositive")
    @Description("Check status Line OK getBookingIdsPositive")
    @Test
    public void getBookingIdsStatusLineOk() throws IOException {
        bookingClient.getBookingIds()
                .then()
                .statusLine(containsString("OK"));
    }

    @DisplayName("Check Content Type getBookingIdsPositive")
    @Description("Check Content Type getBookingIdsPositive")
    @Test
    public void getBookingIdsVerifyContentType() throws IOException {
        bookingClient.getBookingIds()
                .then()
                .contentType("application/json; charset=utf-8");
    }
}
