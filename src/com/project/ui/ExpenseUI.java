package com.project.ui;

import com.project.model.Expense;
import com.project.service.ExpenseService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ExpenseUI {

    private Scanner scanner;
    private ExpenseService expenseService;

    public ExpenseUI(){
        this.scanner = new Scanner(System.in);
        this.expenseService = new ExpenseService();
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
            printHistory(expenseService.getExpenses());
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
        double amount = getAmount();
        scanner.nextLine(); //eat up the newline

        System.out.print("\nEnter Payment Method (CARD or CASH): ");
        String paymentMethod = scanner.nextLine().toUpperCase();
        System.out.println("\n\n");

        this.expenseService.addTransaction(category,amount,paymentMethod);
    }

    private  String center(String text, int width){
        int padding = width - text.length(); //6
        int left = padding / 2; // 6 / 2 =  3
        int right = padding - left; //6 - 3 = 3
        return   "|" + " ".repeat(left) + text +  " ".repeat(right);

    }

    private void columns(){
        System.out.print("-".repeat(85) + "\n" + center("DATE",20) +
                center("CATEGORY", 20) +
                center("AMOUNT", 20) +
                center("PAYMENT", 20)  +"|\n");
    }


    private void printHistory(List<Expense> expenses){
        if(expenses.isEmpty()){
            System.out.println("No transactions found....");
            return;
        }
        this.columns();
        for(int i = 0; i < expenses.size(); i++){
            System.out.println(expenses.get(i));
        }
        System.out.println("-".repeat(85));
    }


    //-------HANDLE AMOUNT INPUT-------------
    private double getAmount(){
        while(true){
            try{
                return scanner.nextDouble();
            }catch (InputMismatchException ime){
                System.out.println("Invalid amount. Enter a number: ");
            }
        }
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
