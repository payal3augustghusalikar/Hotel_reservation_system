package com.hotelreservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static java.time.LocalDate.parse;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class HotelReservation {
    ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
    Hotel hotel;
    Calendar calendar = Calendar.getInstance();

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

                    System.out.println("enter the rate for regular customer for weekdays");
                    int weekDaysRate = scanner1.nextInt();

                    System.out.println("enter the rate for regular customer for weekdays");
                    int weekendRates = scanner1.nextInt();

                    Hotel hotel = new Hotel(hotelName, weekDaysRate, weekendRates);

                    hotelList.add(hotel);
                    System.out.println("Your Details has taken");
                    System.out.println("\n you can add multiple hotel's entry");
                    System.out.println("------------------------------------");
                }
                case 2 -> {
                    System.out.println("the hotels are :");
                    displayHotel();
                }
                case 3 -> {
                    checkWithDate();
                }
                case 4 -> {
                    System.out.println("Thanks for contacting us !!!");
                }
                default -> System.out.println("please enter right choice");
            }
        }
    }

    public void displayHotel() {
        System.out.println("\n Entered Hotel Details is:");
        for (Hotel hotel : hotelList) {
            System.out.println(hotel.toString());
        }
    }

    void checkWithDate() {

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

            getTotalRateForDays(DaysBetween);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Please enter date in format as shown");
        }
    }


    void getTotalRateForDays(long DaysBetween) {
        Map<String, Long> map = null;
        try {
            System.out.println("\n All Hotels with Name and total rates your checkout days are :");
            for (int i = 0; i < hotelList.size(); i++) {
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                if (dayOfWeek ==  7 || dayOfWeek == 1) {
                    System.out.println(+dayOfWeek);
                long totalAmountForStayingDays = DaysBetween * hotelList.get(i).weekDaysRate;
                map = new TreeMap<String, Long>();
                map.put(hotelList.get(i).hotelName, totalAmountForStayingDays);
                System.out.println("---->" + hotelList.get(i).hotelName + "=>" + totalAmountForStayingDays);
                    continue;
                }}
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("multiplication error");
        }
        //System.out.println("for given days cheapest hotels are : " + map);

        Map<String, Long> sortHotelByAscendingRates = map .entrySet() .
                stream() .sorted(comparingByValue()) .
                collect( toMap(e -> e.getKey(), e -> e.getValue(),
                        (e1, e2) -> e2, LinkedHashMap::new));
        System.out.println("cheapest Hotel for checked in days is : " + sortHotelByAscendingRates);
        System.out.println("The hotel is: " + map.keySet() + "\n");
    }
}




