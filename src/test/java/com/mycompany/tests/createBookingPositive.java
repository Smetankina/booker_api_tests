package com.mycompany.tests;

import io.restassured.module.jsv.JsonSchemaValidator;
import com.mycompany.utils.client.BookingClient;
import com.mycompany.utils.model.Booking;
import com.mycompany.utils.model.RandomBooking;
import io.restassured.response.ValidatableResponse;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class createBookingPositive {
    BookingClient bookingClient = new BookingClient();

    @Description("Success code 200 OK")
    @Test
    public void createBooking200OK() throws IOException {
        // Создаем случайное бронирование
        Booking randomBooking = new RandomBooking();

        // Отправляем запрос на создание бронирования
        bookingClient.createBooking(randomBooking).statusCode(200);

    }

    @Description("Checkin date should be less then Checkout date")
    @Test
    public void checkCheckinCheckoutDates() throws IOException, ParseException {
        Booking randomBooking = new RandomBooking();
        // Sending create booking request
        ValidatableResponse response = bookingClient.createBooking(randomBooking);
        String checkinString = response.extract().path("booking.bookingdates.checkin");
        String checkoutString = response.extract().path("booking.bookingdates.checkout");
        //formatter from pattern
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        //Parsing String to the type Date
        Date checkin = formatter.parse(checkinString);
        Date checkout = formatter.parse(checkoutString);

        Assert.assertTrue(checkin.before(checkout), "Checkin date " + checkinString + " is not before the checkout date " + checkoutString);
    }

    @Description("Check the response structure")
    @Test

    public void checkResponseStructure() throws IOException {
        Booking randomBooking = new RandomBooking();
        ValidatableResponse response = bookingClient.createBooking(randomBooking);

        // Проверка ответа на соответствие JSON Schema
        response

                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("bookingSchema.json"));
    }

}
