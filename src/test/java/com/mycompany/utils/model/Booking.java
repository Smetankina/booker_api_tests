package com.mycompany.utils.model;

import com.google.gson.annotations.Expose;

public class Booking {
    @Expose
    String firstname;

    @Expose
    String lastname;

    @Expose
    int totalprice;

    @Expose
    boolean depositpaid;

    @Expose
    BookingDates bookingdates;

    @Expose
    String additionalneeds;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public BookingDates getBookingdates() {
        return bookingdates;
    }

    public void setBookingDates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public Booking(String firstname, String lastname, int totalPrice, boolean depositPaid, BookingDates bookingdates, String additionalNeeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalPrice;
        this.depositpaid = depositPaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalNeeds;
    }

    public Booking() {}
}
