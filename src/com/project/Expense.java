package com.project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Expense {

    //declaring fields
    //to hold date of transaction date and time
    private LocalDateTime date;
    //to hold category type
    private String category;
    //amount for transaction
    private int amount;
    //payment method and notes
    private String paymentMethod;

    public Expense(LocalDateTime date, String category, int amount, String paymentMethod) {
        this.date = date;
        this.category = category;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }



    //If users would like to see the time of their purchases
    public String getTime(){
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");
        return this.date.format(formatterTime);
    }


    //to format the date better
    private String getDate(){
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        return this.date.format(formatterDate);
    }

    //side note: width cannot be less than text length for this to work
    //helper method to center
    private  String center(String text, int width){
        int padding = width - text.length(); //6
        int left = padding / 2; // 6 / 2 =  3
        int right = padding - left; //6 - 3 = 3
        return   "|" + " ".repeat(left) + text +  " ".repeat(right);

    }


    @Override
    public String toString(){
//        COLUMN header will have to go in list class will make later
        return
                center("DATE",10) +
                center("CATEGORY", 10) +
                center("AMOUNT", 10) +
                center("PAYMENT", 10)  +"|\n" +
                center(getDate(),10) +
                center(this.category,10) +
                center(Integer.toString(this.amount),10) +
                center(this.paymentMethod,10) + "|";
    }
}
