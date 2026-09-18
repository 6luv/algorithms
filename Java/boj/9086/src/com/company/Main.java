package com.company;

import java.io.*;
import java.nio.Buffer;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
	    for (int i = 0; i < n; i ++) {
	        String word = bf.readLine();
	        int word_length = word.length();
	        char[] arr = word.toCharArray();
	        if (word_length == 1) {
                System.out.printf("%c%c\n", arr[0], arr[0]);
            } else {
                System.out.printf("%c%c\n", arr[0], arr[word_length-1]);
            }
        }
    }
}
