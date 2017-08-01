package com.ragnardev;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MyClass {

    public static void main(String[] args) {

        MyClass myClass = new MyClass();

        while(true){
            String in = new Scanner(System.in).next();
            int n = Integer.parseInt(in);
            System.out.println(myClass.countNumbersWithUniqueDigits(n));

        }
    }

    private int countNumbersWithUniqueDigits(int n) {
        if (n == 0)     return 1;

        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
        }
        return res;
    }
}
