package com.hotelreservation;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservation {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
    public static void main(String[] args) {
        HotelReservation hotelReservation = new HotelReservation();
        System.out.println("********* Welcome to hotel reservation system ********");
        hotelReservation.addHotel();
    }

    public void addHotel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\"Select the hotel in miami from given option: \n"
                + "1) add hotel\n"
                + "2) display hotel\n"
                + "3) \n"
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
                System.out.println("the hotel are");
                displayHotel();
            }
            case 3 -> {
                System.out.println("");

                break;
            }
            default -> System.out.println("please enter right choice");
        }
    }


    public void displayHotel() {
        System.out.println("\nEntered Person Details is:");
        for (Hotel hotel : hotelList) {
            System.out.println(hotel.toString());
        }
    }
}
