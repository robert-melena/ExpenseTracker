package com.project;

import java.util.ArrayList;
import java.util.List;

public class ExpenseHistory {

    //NOTE: will handle choices in respective methods next!
    private List<Expense> expenses;

    public ExpenseHistory(){
        this.expenses = new ArrayList<>();
    }

    public void addTransaction(String category, int amount,String paymentMethod){
        this.expenses.add(new Expense(category,amount,paymentMethod));
    }

    public void viewHistory(){
        this.columns();
        this.expenses.forEach(expense -> System.out.println(expense));
    }

    private  String center(String text, int width){
        int padding = width - text.length(); //6
        int left = padding / 2; // 6 / 2 =  3
        int right = padding - left; //6 - 3 = 3
        return   "|" + " ".repeat(left) + text +  " ".repeat(right);

    }

    private void columns(){
        System.out.print(center("DATE",20) +
                center("CATEGORY", 20) +
                center("AMOUNT", 20) +
                center("PAYMENT", 20)  +"|\n");
    }

}
