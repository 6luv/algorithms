package com.company;

import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	    Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(bf.readLine());
	    for (int i = 0; i < n; i ++) {
        	String word = bf.readLine();
        	int word_length = word.length();
        	char[] arr = word.toCharArray();
        	for (int j = 0; j < word_length; j ++) {
        		if (Character.isLowerCase(arr[0])) {
        			arr[0] -= 32;
				}
			}
			System.out.println(arr);
	    }

    }
}
