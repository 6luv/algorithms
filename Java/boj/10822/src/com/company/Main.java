package com.company;

import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String number = bf.readLine();
        int sum = 0;

        if (number.contains(",")) { //문자열 안에 ,가 있는지 확인
            String[] spt = number.split(",");

            for (int i = 0; i < spt.length; i ++) {
                sum += Integer.parseInt(spt[i]);
            }
            System.out.println(sum);
        } else {
            System.out.println(number);
        }
    }
}