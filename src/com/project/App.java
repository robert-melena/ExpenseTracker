package com.project;

public class App {
    public static void main(String[] args) {

        ExpenseUI ui = new ExpenseUI();
        ui.start();

        Expense expense = new Expense("Food",145,"CARD");
        System.out.println(expense);

    }

}


