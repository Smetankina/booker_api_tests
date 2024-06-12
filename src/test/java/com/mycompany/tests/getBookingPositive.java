package com.mycompany.tests;


import com.mycompany.utils.client.BookingClient;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.IsNot.not;

public class getBookingPositive {

    BookingClient bookingClient = new BookingClient();
    Random random = new Random();

    @DisplayName("Check body response key Id isNotEmpty getBookingById")
    @Test
    public void getBookingByIdNotEmpty() throws IOException {
        ArrayList w = bookingClient.getBookingIds().path("bookingid");
        int id = (int) w.get(random.nextInt(w.size()));

  //    String response = bookingClient.getBookingPositive(id).extract().body().asPrettyString();
      bookingClient.getBooking(id).body("firstname", not(empty()));

    }

    @DisplayName("Check content type getBookingById")
    @Test
    public void getBookingByIdCorrectContentType() throws IOException {
        ArrayList w = bookingClient.getBookingIds().path("bookingid");
        int id = (int) w.get(random.nextInt(w.size()));

        bookingClient.getBooking(id)
                .statusCode(200)
                .contentType(ContentType.JSON);

    }

}
