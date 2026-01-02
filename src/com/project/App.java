package com.project;

import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {

        Expense expense = new Expense(LocalDateTime.now(),"Food",145,"CARD");
        System.out.println(expense);



    }

}


