package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default

        super(name, balance);
        this.rate = rate;
        this.maxWithdrawalLimit = maxWithdrawalLimit;

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance

        if (amount > maxWithdrawalLimit) {
            throw new Exception("Maximum Withdraw Limit Exceed");
        }

        if (amount > super.getBalance()) {
            throw new Exception("Insufficient Balance");
        }

        super.setBalance(super.getBalance() - amount);
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount

        /*
        Simple Interest = (P x T x R)/100
        Where,

        P is the principal amount
        T is the time and
        R is the rate
         */

        return (double) (super.getBalance() * years * rate) / 100;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year

        // Principle*(1+(rate / 100))^time – Principle

        return (double) super.getBalance() * (Math.pow((1 + rate / 100), times))  - super.getBalance();
    }

}
