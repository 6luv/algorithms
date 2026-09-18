package com.company;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    int upper = 0, lower = 0, gap = 0, num = 0;
	    while(input.hasNextLine()) { //EOF 처리
            String word = input.nextLine();
            int word_length = word.length();
            char[] arr = word.toCharArray();
            for (int i = 0; i < word_length; i++) {
                if (Character.isLowerCase(arr[i])) {
                    lower++;
                } else if (Character.isUpperCase(arr[i])) {
                    upper++;
                } else if (Character.isDigit(arr[i])) {
                    num++;
                } else if (arr[i] == ' ') {
                    gap++;
                }
            }
            System.out.printf("%d %d %d %d\n", lower, upper, num, gap);
            lower = 0;
            upper = 0;
            num = 0;
            gap = 0;
        }
    }
}
