package com.example.hackerrank;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeConversion {
    public static void main(String[] args) {
        timeConversion("12:00:00PM");
    }

    static void timeConversion(String timeIn12h) {
        LocalTime timeIn24h = LocalTime.parse(timeIn12h, DateTimeFormatter.ofPattern("hh:mm:ssa"));
        System.out.println(timeIn24h.format(DateTimeFormatter.ISO_TIME));
    }
}
