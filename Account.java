package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account{
    private int accountNumber;
    private int pinNumber;
    private double savingBalance = 0;
    private double checkingBalance = 0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,###.00");

    //The customer selects what account they want to enter either savings or checking
    protected void getAccountType() {
        System.out.print("1 - Checking Account" + "\n" + "2 - Saving Account" + "\n" + "3 - Exit" + "\n" + "Enter: ");
        int customerSelection = input.nextInt();
        System.out.println();

        switch (customerSelection) {
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case  3:
                System.out.println("Thank you for using Annison's ATM Machine, have a nice day!" + "\n");
                break;
            default:
                System.out.println("Invalid Option. Please pick one of the options shown.");
                getAccountType();
        }
    }

    protected void setAccountNumber(int accNum){
        this.accountNumber = accNum;
    }

    protected int getAccountNumber(){
        return this.accountNumber;
    }

    protected void setPinNumber(int pin){
        this.pinNumber = pin;
    }

    protected int getPinNumber(){
        return this.pinNumber;
    }

    private double getSavingBalance(){
        return this.savingBalance;
    }

    private void calcSavingWithdraw(double withdraw){
       this.savingBalance -= withdraw;
    }

    private double calcSavingDeposit(double deposit){
        return this.savingBalance += deposit;
    }

    private void getSavingWithdrawInput(){
        double amount;

        System.out.println("Saving Account Balance: " + moneyFormat.format(this.savingBalance));
        System.out.print("Enter Amount to Withdraw: ");
        amount = input.nextDouble();
        System.out.println();

        if(amount < savingBalance){
            calcSavingWithdraw(amount);
        }else
            throw new IllegalArgumentException("Amount Can Not be Negative." + "\n");

    }

    private void getSavingDepositInput(){
        double amount;

        System.out.println("Checking Account Balance: " + moneyFormat.format(this.savingBalance));
        System.out.print("Enter Amount to Deposit: ");
        amount = input.nextDouble();
        System.out.println();

        if(amount > savingBalance)
            calcSavingDeposit(amount);

    }

    private void getSaving(){
        System.out.println("Saving Balance: " + moneyFormat.format(getSavingBalance()));
        System.out.println("1 - Deposit Funds");
        System.out.println("2 - Withdraw Funds");
        System.out.println("3 - Previous Page");
        System.out.println("4 - Exit");
        System.out.print("Enter: ");
        int customerSelection = input.nextInt();
        System.out.println();

        switch(customerSelection){
            case 1:
                getSavingDepositInput();
                getSaving();
                break;
            case 2:
                getSavingWithdrawInput();
                getSavingBalance();
                getSaving();
                break;
            case 3:
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using Annison's ATM Machine, have a nice day!" + "\n");
                break;
            default:
                System.out.println("Invalid Option. Please pick one of the options shown.");
                getAccountType();

        }
    }

    private double getCheckingBalance(){
        return this.checkingBalance;
    }

    private void calcCheckingWithdraw(double amount){
        this.checkingBalance -= amount;
    }

    private double calcCheckingDeposit(double deposit){
        return this.checkingBalance += deposit;
    }

    private void getChecking(){
        System.out.println("Checking Balance: " + moneyFormat.format(getCheckingBalance()));
        System.out.println("1 - Deposit Funds");
        System.out.println("2 - Withdraw Funds");
        System.out.println("3 - Previous Page");
        System.out.println("4 - Exit");
        System.out.print("Enter: ");
        int customerSelection = input.nextInt();
        System.out.println();

        switch(customerSelection) {
            case 1:
                getCheckingDepositInput();
                getChecking();
                break;
            case 2:
                getCheckingWithdrawInput();
                getChecking();
                break;
            case 3:
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using Annison's ATM Machine, have a nice day!" + "\n");
                break;
            default:
                System.out.println("Invalid Option. Please pick one of the options shown.");
                getAccountType();
        }
    }

    /*
     *Ask the Customer to deposit into the checking account
     *Check and see if the value entered is within the parameters example tempVar >= 0
     *recall to the setCheckingBalance method
    */
    private void getCheckingDepositInput(){
        double amount;

        System.out.println("Checking Account Balance: " + moneyFormat.format(this.checkingBalance));
        System.out.print("Enter Amount to Deposit: ");
        amount = input.nextDouble();
        System.out.println();

        if(amount > 0.00){
            calcCheckingDeposit(amount);
        }else {
            System.out.println("Please Enter Valid Amount." + "\n");
            getCheckingDepositInput();
        }

    }

    /*
     *Same as getCheckingDepositInput but instead of depositing you are withdrawing
     */
    private void getCheckingWithdrawInput(){
        double amount;
        System.out.println("Checking Account Balance: " + moneyFormat.format(this.checkingBalance));
        System.out.print("Enter Amount to Withdraw: ");
        amount = input.nextDouble();
        System.out.println();

        if(amount <= checkingBalance){
            calcCheckingWithdraw(amount);
        }else{
            System.out.println("Insufficient Funds");
            getCheckingWithdrawInput();
        }
    }

}//End of Class
