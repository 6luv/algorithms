package com.company;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    String word = input.nextLine();
	    int word_length = word.length();
	    char[] arr = word.toCharArray();
	    for(int i = 0; i < word_length; i++) {
	        if (Character.isUpperCase(arr[i])) {
                arr[i] += 32;
            } else {
                arr[i] -= 32;
            }
        }
        System.out.println(arr);
    }
}
