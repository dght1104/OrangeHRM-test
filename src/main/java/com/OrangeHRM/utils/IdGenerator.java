package com.OrangeHRM.utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class IdGenerator {

    public static String generateEmployeeId() {
        String time = LocalTime.now()
                .format(DateTimeFormatter.ofPattern("mmss"));

        return "EMP" + time;
    }

    public static String generateRandomString() {
        int number = (int) (Math.random() * 9000) + 1000;
        return String.valueOf(number);
    }
}