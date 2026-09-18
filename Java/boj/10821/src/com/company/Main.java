package com.company;

import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String number = bf.readLine();
        int sum = 1;
        int num_length = number.length();
        char[] arr = number.toCharArray();
        for (int i = 0; i < num_length; i ++) {
            if (arr[i] == ',') {
                sum++;
            }
        }
        System.out.println(sum);
    }
}
