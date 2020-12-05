package com.hotelreservation;

public class Hotel {
    String hotelName;
    int rates;

    public Hotel(String hotelName, int rates) {

        this.hotelName = hotelName;
        this.rates = rates;

    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
}

