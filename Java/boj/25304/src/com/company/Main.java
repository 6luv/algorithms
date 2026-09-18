package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x, n, price, num, sum = 0;

        x = sc.nextInt();
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            price = sc.nextInt();
            num = sc.nextInt();
            sum += price * num;
        }

        if (x == sum) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
