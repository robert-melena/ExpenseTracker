package com.project.service;

import com.project.model.Category;
import com.project.model.Expense;
import com.project.model.Payment;

import java.util.ArrayList;
import java.util.List;

public class ExpenseService {

    //NOTE: will handle choices in respective methods next!
    private List<Expense> expenses;

    public ExpenseService(){
        this.expenses = new ArrayList<>();
    }

    public void addExpense(Category category, double amount, Payment paymentMethod){
        this.expenses.add(new Expense(category,amount,paymentMethod));
    }

    public List<Expense> getExpenses(){
        return this.expenses;
    }

    public boolean isEmpty(){
        return expenses.isEmpty();
    }
}
