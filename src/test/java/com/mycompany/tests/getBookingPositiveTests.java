package com.mycompany.tests;

import com.mycompany.utils.client.BookingClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.IsNot.not;

public class getBookingPositiveTests {
    BookingClient bookingClient = new BookingClient();
    Random random = new Random();

    @DisplayName("Check body response key Id isNotEmpty getBookingById")
    @Description("Check body response key Id isNotEmpty getBookingById")
    @Test
    public void getBookingByIdNotEmpty() throws IOException {
        ArrayList<Integer> bookingIds = bookingClient.getBookingIds().path("bookingid");
        int id = bookingIds.get(random.nextInt(bookingIds.size()));

        bookingClient.getBooking(id).body("firstname", not(empty()));
    }

    @DisplayName("Check content type getBookingById")
    @Description("Check content type getBookingById")
    @Test
    public void getBookingByIdCorrectContentType() throws IOException {
        ArrayList<Integer> bookingIds = bookingClient.getBookingIds().path("bookingid");
        int id = bookingIds.get(random.nextInt(bookingIds.size()));

        bookingClient.getBooking(id)
                .statusCode(200)
                .contentType(ContentType.JSON);
    }
}
