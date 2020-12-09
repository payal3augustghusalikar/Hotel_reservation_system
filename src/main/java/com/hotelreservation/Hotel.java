package com.hotelreservation;

public class Hotel {
    String hotelName;
    int weekDaysRate;
    int weekendRates;

    public Hotel(String hotelName,  int weekDaysRate, int weekendRates) {

        this.hotelName = hotelName;
        this.weekDaysRate = weekDaysRate;
        this.weekendRates = weekendRates;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }


    public int getWeekDaysRate() {
        return weekDaysRate;
    }

    public void setWeekDaysRate(int weekDaysRate) {
        this.weekDaysRate = weekDaysRate;
    }

    public int getWeekendRates() {
        return weekendRates;
    }

    public void setWeekendRates(int weekendRates) {
        this.weekendRates = weekendRates;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", weekDaysRate=" + weekDaysRate +
                ", weekendRates=" + weekendRates +
                '}';
    }
}

