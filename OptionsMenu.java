package com.company;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionsMenu extends Account{
    Scanner customerInput = new Scanner(System.in);
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    /*Customer enters their account number and pin
       both account number and pin are checked for validation
       if not validated then exception will be thrown
     */
    protected void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(1234, 9876);
                data.put(9876, 1234);

                System.out.println("Hello, welcome to Annison's ATM Machine!");
                System.out.print("Please enter your account number:");
                setAccountNumber(customerInput.nextInt());

                System.out.print("Please enter your pin number:");
                setPinNumber(customerInput.nextInt());
                System.out.println();

            } catch (Exception e) {
                System.out.println("Please enter a valid character(s). Only numbers." + "\n");
                x = 2;
            }

            int cn = getAccountNumber();
            int pn = getPinNumber();
            if (data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType();
            } else
                System.out.println("Wrong Customer Number or Pin Number" + "Please try again");
        }while (x == 1) ;
    }
}//End of Class
