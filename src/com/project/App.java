package com.project;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) {


        LocalDate date = LocalDate.now();
        System.out.println(date);
        System.out.println(formattedDate());

    }

    public static String formattedDate(){
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        return time.format(timeFormatter);
    }


}


