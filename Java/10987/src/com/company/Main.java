package com.company;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    String word = input.nextLine();
	    int word_length = word.length();
	    int cnt = 0;

	    char[] arr = word.toCharArray();
	    for (int i = 0; i < word_length; i ++) {
	        if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' ||arr[i] == 'u') {
	            cnt++;
            }
        }
        System.out.println(cnt);
    }
}
