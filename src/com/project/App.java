package com.project;

import com.project.ui.ExpenseUI;

public class App {
    public static void main(String[] args) {

        //Next thing to do will be to add Account so users can view their own expenses
        //then create another class to actually start entire application
        ExpenseUI expenseUi = new ExpenseUI();
        expenseUi.start();

//        String category = "pizza";
//
//        for(Category cat : Category.values()){
//            if(validCategory(category,cat)){
//                System.out.println("Valid category!");
//            }
//        }
//        System.out.println("Invalid category");


    }

//    public static boolean validCategory(String str, Category category){
//        return str.equalsIgnoreCase(category.toString());
//    }

}


