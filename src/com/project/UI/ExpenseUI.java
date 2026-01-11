package com.project.UI;

import com.project.service.ExpenseHistory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExpenseUI {

    private Scanner scanner;
    private ExpenseHistory history;

    public ExpenseUI(){
        this.scanner = new Scanner(System.in);
        this.history = new ExpenseHistory();
    }

//    START EXPENSE UI
    public void start(){
        System.out.println("-".repeat(15) + " EXPENSE TRACKER" + "-".repeat(15));
        displayUserSelection();
    }

//    DISPLAY USER SELECTION
    private void displayUserSelection(){

        int option = 0;
        do{
           option = displayChoices();
            //clear buffer or else will loop infinitely
            scanner.nextLine();
            //handle choices next
            performAction(option);

        }while(option != 3);

        System.out.println("\n\nExiting Program....");
    }

//    PERFORM ACTION
    private void performAction(int option){
        if(option == 1){
            getTransactionInfo();
        }else if(option == 2){
            this.history.viewHistory();
        }
    }

//    DISPLAY CHOICES
    private int displayChoices(){
        System.out.println("1. Add Transaction");
        System.out.println("2. Browse Transaction History");
        System.out.println("3. Exit");
        System.out.print("Select (1,2, or 3): " );
        try{
             return scanner.nextInt();
        }catch (InputMismatchException nfe){
            System.out.println("INVALID INPUT");
        }
        return 0;
    }

    private void getTransactionInfo(){
        System.out.print("Enter Category (FOOD,ENTERTAINMENT,TRAVEL,ETC.) : ");
        String category = getCategory();

//        NOW HANDLE AMOUNT INPUT and PAYMENT INPUT NOTE <<<<------------------
        System.out.print("\nEnter Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); //eat up the newline

        System.out.print("\nEnter Payment Method: ");
        String paymentMethod = scanner.nextLine().toUpperCase();
        System.out.println("\n\n");

        this.history.addTransaction(category,amount,paymentMethod);
    }



    //---------HANDLE CATEGORY INPUT-------------
    private String getCategory(){
        String category = scanner.nextLine().toUpperCase();
        while(isNumeric(category)){
            System.out.print("Enter Category (FOOD,ENTERTAINMENT,TRAVEL,ETC.) : ");
            category = scanner.nextLine().toUpperCase();
        }
        return category;
    }
    //---------HANDLE CATEGORY INPUT-------------
    private boolean isNumeric(String string){
        if(string == null){
            return false;
        }
        try {
            Double.parseDouble(string);
            return true;
        }catch(NumberFormatException nfe){
            return false;
        }
    }
}
