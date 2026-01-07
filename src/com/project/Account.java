package com.project;

public class Account {
    private String username;
    private String password;
    private ExpenseHistory history;

    public Account (String username,String password){
        this.username = username;
        this.password = password;
        this.history = new ExpenseHistory();
    }

    public boolean validateCredentials(String username, String password){
        return this.username.equals(username) && this.password.equals(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ExpenseHistory getHistory() {
        return history;
    }

    public void setHistory(ExpenseHistory history) {
        this.history = history;
    }
}
