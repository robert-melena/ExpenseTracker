package com.project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExpenseUI {

    private Scanner scanner;
    private ExpenseHistory history;

    public ExpenseUI(){
        this.scanner = new Scanner(System.in);
        this.history = new ExpenseHistory();
    }

    public void start(){
        System.out.println("-".repeat(15) + " EXPENSE TRACKER" + "-".repeat(15));
        userSelectionDisplay();
    }

    private void userSelectionDisplay(){

        int option = 0;
        do{

            try{
                displayChoices();
                option = scanner.nextInt();

            }catch (InputMismatchException e){
                System.out.println("INVALID INPUT...");
            }
            //clear buffer or else will loop infinitely
            scanner.nextLine();
            //handle choices next
            if(option == 1){
                getTransactionInfo();
            }else if(option == 2){
                this.history.viewHistory();
            }
        }while(option != 3);

        System.out.println("\n\nExiting Program....");
    }


    private void displayChoices(){
        System.out.println("1. Add Transaction");
        System.out.println("2. Browse Transaction History");
        System.out.println("3. Exit");
        System.out.print("Select (1,2, or 3): " );
    }

    private void getTransactionInfo(){
        System.out.print("Enter Category: ");
        String category = scanner.nextLine().toUpperCase();

        System.out.print("\nEnter Amount: ");
        int amount = scanner.nextInt();
        scanner.nextLine(); //eat up the newline

        System.out.print("\nEnter Payment Method: ");
        String paymentMethod = scanner.nextLine().toUpperCase();
        System.out.println("\n\n");

        this.history.addTransaction(category,amount,paymentMethod);
    }
}
