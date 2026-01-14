package com.project.ui;

import com.project.model.Category;
import com.project.model.Expense;
import com.project.model.Payment;
import com.project.service.ExpenseService;

import java.util.Arrays;
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
        //category input
        Category category = getCategory();

        //amount input
        double amount = getAmount();
        scanner.nextLine(); //eat up the newline

        //payment input DO THIS NEXT
        Payment paymentMethod = getPaymentMethod();

        this.expenseService.addExpense(category,amount,paymentMethod);
        System.out.println("---Payment Successfully Added---");
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

    //-------HANDLE PAYMENT METHOD INPUT-------------
    private String getPaymentMethod(){
        System.out.print("\nEnter Payment Method (CARD,CASH or APPLEPAY): ");
        String paymentMethod = scanner.nextLine().toUpperCase();

        while(!isValidPaymentMethod(paymentMethod)){
            System.out.print("\nEnter Payment Method (CARD,CASH or APPLEPAY): ");
            paymentMethod = scanner.nextLine().toUpperCase();
        }
        return paymentMethod;
    }

    //-------HANDLE PAYMENT METHOD INPUT-------------
    private boolean isValidPaymentMethod(String paymentMethod){
        return Arrays.stream(Payment.values()).anyMatch(payment -> payment.toString().equalsIgnoreCase(paymentMethod));
    }


    //-------HANDLE AMOUNT INPUT-------------
    private double getAmount(){
        while(true){
            try{
                System.out.print("\nEnter Amount: ");
                return scanner.nextDouble();
            }catch (InputMismatchException ime){
                System.out.println("Invalid amount. Enter a number: ");
                scanner.nextLine(); // clear bad input

            }
        }
    }


    //---------HANDLE CATEGORY INPUT-------------
    private Category getCategory(){
        System.out.print("Enter Category (FOOD,ENTERTAINMENT,TRAVEL,ETC.) : ");
        String category = scanner.nextLine().toUpperCase();
        while(isNumeric(category) || !isValidCategory(category)){
            System.out.print("Enter Category (FOOD,ENTERTAINMENT,TRAVEL,ETC.) : ");
            category = scanner.nextLine().toUpperCase();
        }
        return Category.valueOf(category);
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

    //---------HANDLE CATEGORY INPUT-------------
    private boolean isValidCategory(String category){
        return Arrays.asList(Category.values())
                .stream()
                .anyMatch(cat -> cat.toString().equalsIgnoreCase(category));
    }

}
