package com.company;

import java.math.BigInteger;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
		BigInteger bigInteger = new BigInteger("10000000000000000000000000");
	    Scanner input = new Scanner(System.in);
	    BigInteger money = input.nextBigInteger();
		BigInteger num = input.nextBigInteger();
		BigInteger b[] = money.divideAndRemainder(num);
		System.out.println(b[0]);
		System.out.println(b[1]);
    }
}
