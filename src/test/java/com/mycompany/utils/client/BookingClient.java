package com.mycompany.utils.client;

import com.mycompany.utils.model.Booking;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;


import java.io.IOException;

import static io.restassured.RestAssured.given;

public class BookingClient extends BaseClient{



    public Response getBookingIds() throws IOException {
        return given().spec(baseSpec())
                .when()
                .get("/booking");

    }

    public ValidatableResponse getBooking(int id) throws IOException {
        return given().spec(baseSpec())
                .pathParam("id",id)
                .when()
                .get("/booking/{id}").then();

    }

    public ValidatableResponse createBooking(Booking booking) throws IOException{
        return given().spec(baseSpec())
             //   .log().body()
                .when()
                .body(booking)
                .post("/booking")
                .then();
    }

}
