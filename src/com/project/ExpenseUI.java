package com.project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExpenseUI {

    Scanner scanner;
    public ExpenseUI(){
        this.scanner = new Scanner(System.in);
    }

    public void start(){
        System.out.println("-".repeat(15) + " EXPENSE TRACKER" + "-".repeat(15));
        userSelection();
    }

    private void userSelection(){

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

        }while(option != 3);
    }

    //NOTE: will handle choices in respective methods next!



    private void displayChoices(){
        System.out.println("1. Add Transaction");
        System.out.println("2. Browse Transaction History");
        System.out.println("3. Exit");
    }
}
