package com.company;
import java.io.IOException;
public class ATM extends OptionsMenu{

    public static void main(String[] args) throws IOException{
        OptionsMenu Menu = new OptionsMenu();
        System.out.println("The account number and pin are both hard coded" + "\n" + "Please use Account number 1234, and Pin number 9876" + "\n");
        Menu.getLogin();
    }
}
