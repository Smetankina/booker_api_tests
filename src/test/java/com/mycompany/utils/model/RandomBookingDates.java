package com.mycompany.utils.model;

import com.google.gson.annotations.Expose;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class RandomBookingDates extends BookingDates {
    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

    // Method to generate a random date between two dates and format it as a string
    public static String generateRandomDateString(Date startDate, Date endDate) {
        Date randomDate = generateRandomDate(startDate, endDate);
        return DATE_FORMATTER.format(randomDate);
    }

    // Method to generate a random date between two dates
    private static Date generateRandomDate(Date startDate, Date endDate) {
        long startMillis = startDate.getTime();
        long endMillis = endDate.getTime();
        long randomMillis = ThreadLocalRandom.current().nextLong(startMillis, endMillis);
        return new Date(randomMillis);
    }

    @Expose
    private static String CHECKIN = generateRandomDateString(new Date(946684800000L), new Date(1704067200000L)); // Dates between 2000-01-01 and 2024-01-01
    @Expose
    private static String CHECKOUT = generateRandomDateString(new Date(946684800000L), new Date(1704067200000L));

    public RandomBookingDates() {
        super(CHECKIN, CHECKOUT);
    }
}
