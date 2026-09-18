package com.company;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    String word = input.nextLine();
	    int word_length = word.length();
	    char[] arr = word.toCharArray();
	    for (int i = 0; i < word_length; i ++) {
            System.out.print(arr[i]);
            if (i % 10 == 9) {
                System.out.println();
            }
        }
    }
}
