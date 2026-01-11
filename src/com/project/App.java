package com.project;

import com.project.UI.ExpenseUI;

public class App {
    public static void main(String[] args) {

        //Next thing to do will be to add Account so users can view their own expenses
        //then create another class to actually start entire application
        ExpenseUI expenseUi = new ExpenseUI();
        expenseUi.start();


    }

}


