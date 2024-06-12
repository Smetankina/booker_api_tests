package com.mycompany.utils.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomBooking extends Booking implements Serializable {
    private transient Random random = new Random();

    @Expose
    private static final String FIRSTNAME = RandomStringUtils.random(10, true, true);
    @Expose
    private static final String LASTNAME = RandomStringUtils.random(10, true, true);
    @Expose
    private static final int TOTALPRICE = ThreadLocalRandom.current().nextInt(1000);
    @Expose
    private static final boolean DEPOSITPAID = ThreadLocalRandom.current().nextBoolean();
    @Expose
    private static final RandomBookingDates randomBookingDates = new RandomBookingDates();
    @Expose
    private static final String ADDITIONALNEEDS = RandomStringUtils.random(100, true, true);

    public RandomBooking() {
        super(FIRSTNAME, LASTNAME, TOTALPRICE, DEPOSITPAID, randomBookingDates, ADDITIONALNEEDS);
    }

    public static void main(String[] args) {
        RandomBooking randomBooking = new RandomBooking();

        // Setup GSON with date formatting
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setDateFormat("yyyy-MM-dd") // Set the date format
                .create();

        // Serialize the object to JSON
        String jsonString = gson.toJson(randomBooking);
        System.out.println(jsonString);

        // Deserialize the JSON back to an object
        RandomBooking deserializedRandomBooking = gson.fromJson(jsonString, RandomBooking.class);
        System.out.println("Firstname: " + deserializedRandomBooking.getFirstname());
        System.out.println("Lastname: " + deserializedRandomBooking.getLastname());
        System.out.println("Totalprice: " + deserializedRandomBooking.getTotalprice());
        System.out.println("Depositpaid: " + deserializedRandomBooking.isDepositpaid());
        System.out.println("Additionalneeds: " + deserializedRandomBooking.getAdditionalneeds());
        System.out.println("Checkin: " + deserializedRandomBooking.getBookingdates().getCheckin());
        System.out.println("Checkout: " + deserializedRandomBooking.getBookingdates().getCheckout());
    }
}
