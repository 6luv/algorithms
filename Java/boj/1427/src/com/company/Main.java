package com.company;

import java.util.Arrays;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    StringBuilder sb = new StringBuilder();
	    String num = input.nextLine();
	    char[] arr = num.toCharArray();

	    Arrays.sort(arr);
        System.out.println(new StringBuilder(new String(arr)).reverse());
    }
}
