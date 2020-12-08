package com.hotelreservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

import static java.time.LocalDate.parse;

public class HotelReservation {
    ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
    Hotel hotel;

    public static void main(String[] args) {
        HotelReservation hotelReservation = new HotelReservation();
        System.out.println("********* Welcome to hotel reservation system ********");
        hotelReservation.addHotel();
    }

    public void addHotel() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\"Select the hotel in miami from given option: \n"
                    + "1) add hotel\n"
                    + "2) display hotel\n"
                    + "3) check with date \n"
                    + "4) Quit");
            int numb = scanner.nextInt();

            switch (numb) {
                case 1 -> {
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("enter the name of hotel:");
                    String hotelName = scanner1.nextLine();
                    System.out.println("enter the rate for regular customer");
                    int rates = scanner1.nextInt();
                    Hotel hotel = new Hotel(hotelName, rates);

                    hotelList.add(hotel);
                    System.out.println("Your Details has taken");
                    System.out.println("\n you can add multiple hotel's entry");
                    System.out.println("------------------------------------");
                }
                case 2 -> {
                    System.out.println("the hotels are");
                    displayHotel();
                }
                case 3 -> {
                    findCheapestHotel();
                    System.out.println("for given days cheapest hotels are :");
                    break;
                }
                default -> System.out.println("please enter right choice");
            }
        }
    }

    public void displayHotel() {
        System.out.println("\nEntered Hotel Details is:");
        for (Hotel hotel : hotelList) {
            System.out.println(hotel.toString());
        }
    }

    void findCheapestHotel() {

        Scanner scanner1 = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");

        System.out.println("Add your Start Date (dd MM yyyy)");
        String inputString1 = scanner1.nextLine();

        System.out.println("Add your end Date (dd MM yyyy)");
        String inputString2 = scanner1.nextLine();

        try {
            LocalDate date1 = parse(inputString1, dtf);
            LocalDate date2 = parse(inputString2, dtf);
            long DaysBetween = ChronoUnit.DAYS.between(date1, date2);
            System.out.println("you want to check for Days: " + DaysBetween);
            // long noOfDaysBetweenDates = DaysBetween;
            getTotalRateForDays(DaysBetween);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Please enter date in format as shown");
        }
    }


    void getTotalRateForDays(long DaysBetween) {
        try {
            for (int i = 0; i < hotelList.size(); i++) {

                long totalAmountForStayingDays = DaysBetween * hotelList.get(i).rates;
                // System.out.println(hotel.toString());
                System.out.println(hotelList.get(i).hotelName +" ==> " + totalAmountForStayingDays);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("multiplication error");
        }
    }
}





